package org.sheepy.lily.vulkan.nuklear.pipeline;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.nuklear.NkAllocator;
import org.lwjgl.nuklear.NkBuffer;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.IView;
import org.sheepy.lily.core.model.presentation.IPanel;
import org.sheepy.lily.core.model.presentation.IUIView;
import org.sheepy.lily.core.model.presentation.UIPage;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.engine.VulkanEngineAdapter;
import org.sheepy.lily.vulkan.common.util.ModelUtil;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.enumeration.ECullMode;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicState;
import org.sheepy.lily.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.lily.vulkan.model.process.graphic.ViewportState;
import org.sheepy.lily.vulkan.model.process.graphic.impl.RasterizerImpl;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.nuklear.adapter.IUIElementAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.IUIElementAdapter.UIContext;
import org.sheepy.lily.vulkan.nuklear.input.NuklearInputCatcher;
import org.sheepy.lily.vulkan.nuklear.model.NuklearPipeline;
import org.sheepy.lily.vulkan.nuklear.pipeline.draw.DrawCommandData;
import org.sheepy.lily.vulkan.nuklear.pipeline.draw.DrawRecorder;
import org.sheepy.lily.vulkan.nuklear.pipeline.draw.NuklearDrawer;
import org.sheepy.lily.vulkan.nuklear.pipeline.draw.NuklearResources;
import org.sheepy.lily.vulkan.nuklear.pipeline.factory.ColorBlendFactory;
import org.sheepy.lily.vulkan.nuklear.pipeline.factory.DynamicStateFactory;
import org.sheepy.lily.vulkan.nuklear.pipeline.factory.ViewportStateFactory;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager.Extent2D;
import org.sheepy.lily.vulkan.process.graphic.pipeline.IGraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.resource.indexed.IVertexBufferDescriptor;

@Statefull
@Adapter(scope = NuklearPipeline.class)
public class NuklearPipelineAdapter extends IGraphicsPipelineAdapter
{
	private static final int BUFFER_INITIAL_SIZE = 4 * 1024;

	private final NuklearPipeline nkPipeline;
	private final NuklearResources resources;

	private NkAllocator ALLOCATOR;
	private final NuklearInputCatcher inputCatcher = new NuklearInputCatcher();
	private NkBuffer cmds;
	private NkContext nkContext;

	private DrawRecorder recorder;
	private NuklearDrawer drawer;

	private GraphicContext graphicContext;
	private Window window;

	private boolean dirty = true;
	private VkViewport.Buffer viewport;

	public NuklearPipelineAdapter(NuklearPipeline nkPipeline)
	{
		super(nkPipeline);
		this.nkPipeline = nkPipeline;
		resources = new NuklearResources(nkPipeline);
	}

	@Override
	public List<? extends Object> getResources()
	{
		var res = new ArrayList<Object>(resources.toList());
		res.add(nkPipeline.getPushConstant());
		return res;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		ALLOCATOR = NkAllocator.calloc().alloc((handle, old, size) -> nmemAllocChecked(size))
				.mfree((handle, ptr) -> nmemFree(ptr));

		graphicContext = (GraphicContext) context;
		window = graphicContext.getWindow();
		viewport = VkViewport.calloc(1);

		var engine = getEngine(nkPipeline);
		var application = (Application) engine.eContainer();
		var inputManager = VulkanEngineAdapter.adapt(engine).getInputManager();

		resources.allocate();

		createContext();
		inputManager.setInputCatcher(inputCatcher);

		recorder = new DrawRecorder(nkContext, application.isDebug());
		drawer = new NuklearDrawer(getDescriptorSets(), resources, pipelineLayout);

		// Prepare a first render for the opening of the screen
		layout(Collections.emptyList());
		prepare();
	}

	private VulkanEngine getEngine(EObject eo)
	{
		while (eo != null)
		{
			if (eo instanceof VulkanEngine)
			{
				return (VulkanEngine) eo;
			}
			else
			{
				eo = eo.eContainer();
			}
		}
		return null;
	}

	@Override
	public void free(IAllocationContext context)
	{
		super.free(context);

		// Release all Vulkan resources required for rendering imGui
		viewport.free();
		viewport = null;

		recorder = null;

		resources.free();

		Objects.requireNonNull(nkContext.clip().copy()).free();
		Objects.requireNonNull(nkContext.clip().paste()).free();

		nk_free(nkContext);
		nk_buffer_free(cmds);

		nkContext = null;
		cmds = null;

		Objects.requireNonNull(ALLOCATOR.alloc()).free();
		Objects.requireNonNull(ALLOCATOR.mfree()).free();
		ALLOCATOR.free();
	}

	private void createContext()
	{
		nkContext = NkContext.create();
		cmds = NkBuffer.create();
		nk_init(nkContext, ALLOCATOR, resources.getDefaultFont());
		nk_buffer_init(cmds, ALLOCATOR, BUFFER_INITIAL_SIZE);

		nkContext.style().window().fixed_background().data().color().a((byte) 150);

		inputCatcher.configure(nkContext, window, this);

		nkContext.clip(it -> it.copy((handle, text, len) -> {
			if (len == 0)
			{
				return;
			}

			try (MemoryStack stack = MemoryStack.stackPush())
			{
				ByteBuffer str = stack.malloc(len + 1);
				MemoryUtil.memCopy(text, MemoryUtil.memAddress(str), len);
				str.put(len, (byte) 0);

				glfwSetClipboardString(window.getId(), str);
			}
		}).paste((handle, edit) -> {
			long text = nglfwGetClipboardString(window.getId());
			if (text != 0)
			{
				nnk_textedit_paste(edit, text, nnk_strlen(text));
			}
		}));
	}

	@Override
	public void prepare()
	{
		var indexBuffer = nkPipeline.getIndexBuffer();
		var indexBufferAdapter = NuklearVertexBufferAdapter.adapt(indexBuffer);

		indexBufferAdapter.update(nkContext, cmds);

		recorder.prepare(cmds);
	}

	public void layout(List<IInputEvent> events)
	{
		Application application = ModelUtil.getApplication(nkPipeline);
		IView view = application.getCurrentView();
		UIContext context = new UIContext(window, nkContext, events);

		if (view != null && view instanceof IUIView)
		{
			IUIView uiView = (IUIView) view;
			UIPage uiPage = uiView.getCurrentUIPage();
			if (uiPage != null)
			{
				for (IPanel panel : uiPage.getPanels())
				{
					var panelAdapter = IUIElementAdapter.adapt(panel);
					dirty |= panelAdapter.layout(context, panel);
				}
			}
		}
	}

	@Override
	public boolean isRecordNeeded()
	{
		if (nk_item_is_any_active(nkContext))
		{
			dirty = true;
		}

		dirty |= super.isRecordNeeded();

		if (dirty == false)
		{
			recorder.clear();
		}

		return dirty;
	}

	@Override
	public void record(GraphicCommandBuffer graphicCommandBuffer, int bindPoint)
	{
		var indexBuffer = nkPipeline.getIndexBuffer();
		var indexBufferAdapter = NuklearVertexBufferAdapter.adapt(indexBuffer);
		var commandBuffer = graphicCommandBuffer.getVkCommandBuffer();

		vkCmdBindPipeline(commandBuffer, bindPoint, pipelineId);

		indexBufferAdapter.bind(commandBuffer);

		setViewport(commandBuffer);
		pushConstants(commandBuffer);

		drawer.prepare(bindPoint, graphicContext.surfaceManager.getExtent());
		for (DrawCommandData data : recorder.getDrawCommands())
		{
			drawer.draw(graphicCommandBuffer, data);
		}

		dirty = false;
	}

	private void setViewport(VkCommandBuffer commandBuffer)
	{
		Extent2D extent = graphicContext.surfaceManager.getExtent();
		viewport.get(0).set(0, 0, extent.getWidth(), extent.getHeight(), 1, 1);
		vkCmdSetViewport(commandBuffer, 0, viewport);
	}

	private void pushConstants(VkCommandBuffer commandBuffer)
	{
		var pushAdapter = NuklearConstantsAdapter.adapt(nkPipeline.getPushConstant());
		vkCmdPushConstants(commandBuffer, pipelineLayout, VK_SHADER_STAGE_VERTEX_BIT, 0,
				pushAdapter.getData());
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		return NuklearVertexBufferAdapter.VERTEX_DESCRIPTOR;
	}

	@Override
	public AbstractConstants getConstants()
	{
		return nkPipeline.getPushConstant();
	}

	@Override
	public List<IVkDescriptorSet> getDescriptorSets()
	{
		return resources.getDescriptorSets();
	}

	@Override
	protected List<Shader> getShaders()
	{
		return resources.getShaders();
	}

	@Override
	protected ViewportState getViewportState()
	{
		return ViewportStateFactory.create();
	}

	@Override
	protected Rasterizer getRasterizer()
	{
		var rasterizer = new RasterizerImpl();
		rasterizer.setCullMode(ECullMode.NONE);
		return rasterizer;
	}

	@Override
	protected ColorBlend getColorBlend()
	{
		return ColorBlendFactory.create();
	}

	@Override
	protected DynamicState getDynamicState()
	{
		return DynamicStateFactory.create();
	}

	@Override
	protected int getSubpass()
	{
		return nkPipeline.getSubpass();
	}
}
