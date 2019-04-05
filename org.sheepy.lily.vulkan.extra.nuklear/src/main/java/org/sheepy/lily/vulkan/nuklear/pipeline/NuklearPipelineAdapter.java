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

import org.lwjgl.nuklear.NkAllocator;
import org.lwjgl.nuklear.NkBuffer;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.IView;
import org.sheepy.lily.core.model.presentation.IPanel;
import org.sheepy.lily.core.model.presentation.IUIView;
import org.sheepy.lily.core.model.presentation.UIPage;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.nativehelper.Extent2D;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.api.resource.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.api.resource.IVkDescriptorSet;
import org.sheepy.lily.vulkan.common.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline;
import org.sheepy.lily.vulkan.model.enumeration.ECullMode;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicState;
import org.sheepy.lily.vulkan.model.process.graphic.InputAssembly;
import org.sheepy.lily.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.lily.vulkan.model.process.graphic.ViewportState;
import org.sheepy.lily.vulkan.model.process.graphic.impl.InputAssemblyImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.RasterizerImpl;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.nuklear.adapter.IUIElementAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.IUIElementAdapter.UIContext;
import org.sheepy.lily.vulkan.nuklear.input.NuklearInputCatcher;
import org.sheepy.lily.vulkan.nuklear.pipeline.draw.DrawCommandData;
import org.sheepy.lily.vulkan.nuklear.pipeline.draw.DrawRecorder;
import org.sheepy.lily.vulkan.nuklear.pipeline.draw.NuklearDrawer;
import org.sheepy.lily.vulkan.nuklear.pipeline.draw.NuklearResources;
import org.sheepy.lily.vulkan.nuklear.pipeline.factory.ColorBlendFactory;
import org.sheepy.lily.vulkan.nuklear.pipeline.factory.DynamicStateFactory;
import org.sheepy.lily.vulkan.nuklear.pipeline.factory.ViewportStateFactory;
import org.sheepy.lily.vulkan.process.graphic.pipeline.AbstractGraphicsPipelineAdapter;

@Statefull
@Adapter(scope = NuklearPipeline.class)
public class NuklearPipelineAdapter extends AbstractGraphicsPipelineAdapter
{
	private static final int BUFFER_INITIAL_SIZE = 4 * 1024;

	private final NuklearPipeline nkPipeline;
	private final NuklearResources resources;

	private final NkAllocator ALLOCATOR;
	private final NuklearInputCatcher inputCatcher = new NuklearInputCatcher();
	private NkBuffer cmds;
	private NkContext nkContext;

	private DrawRecorder recorder;
	private NuklearDrawer drawer;

	private IGraphicContext graphicContext;
	private Window window;

	private boolean dirty = true;
	private VkViewport.Buffer viewport;

	public NuklearPipelineAdapter(NuklearPipeline nkPipeline)
	{
		super(nkPipeline);
		this.nkPipeline = nkPipeline;
		resources = new NuklearResources(nkPipeline);

		ALLOCATOR = NkAllocator.calloc().alloc((handle, old, size) -> nmemAllocChecked(size))
				.mfree((handle, ptr) -> nmemFree(ptr));

		viewport = VkViewport.calloc(1);
	}

	@Dispose
	public void dispose()
	{
		Objects.requireNonNull(ALLOCATOR.alloc()).free();
		Objects.requireNonNull(ALLOCATOR.mfree()).free();
		ALLOCATOR.free();

		viewport.free();
		viewport = null;
	}

	@Override
	public void collectResources(List<Object> collectIn)
	{
		collectIn.addAll(resources.toList());
		collectIn.add(nkPipeline.getPushConstant());
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		graphicContext = (IGraphicContext) context;
		window = graphicContext.getWindow();

		final var engine = VulkanModelUtil.getEngine(nkPipeline);
		final var inputManager = IVulkanEngineAdapter.adapt(engine).getInputManager();

		resources.allocate();
		createContext();
		inputManager.setInputCatcher(inputCatcher);

		recorder = new DrawRecorder(nkContext, DebugUtil.DEBUG_ENABLED);

		List<IVkDescriptorSet> descriptorSets = new ArrayList<>();
		collectDescriptorSets(descriptorSets);
		drawer = new NuklearDrawer(descriptorSets, resources, getPipelineLayout());

		// Prepare a first render for the opening of the screen
		layout(Collections.emptyList());
		prepareRecord();
	}

	@Override
	public void free(IAllocationContext context)
	{
		super.free(context);

		// Release all Vulkan resources required for rendering imGui

		recorder = null;

		resources.free();

		Objects.requireNonNull(nkContext.clip().copy()).free();
		Objects.requireNonNull(nkContext.clip().paste()).free();

		nk_free(nkContext);
		nk_buffer_free(cmds);

		nkContext = null;
		cmds = null;
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
				final ByteBuffer str = stack.malloc(len + 1);
				MemoryUtil.memCopy(text, MemoryUtil.memAddress(str), len);
				str.put(len, (byte) 0);

				glfwSetClipboardString(window.getId(), str);
			}
		}).paste((handle, edit) -> {
			final long text = nglfwGetClipboardString(window.getId());
			if (text != 0)
			{
				nnk_textedit_paste(edit, text, nnk_strlen(text));
			}
		}));
	}

	@Override
	public void prepareRecord()
	{
		resources.getVertexBuffer().update(nkContext, cmds);

		recorder.prepare(cmds);
	}

	public void layout(List<IInputEvent> events)
	{
		final Application application = VulkanModelUtil.getApplication(nkPipeline);
		final IView view = application.getCurrentView();
		final UIContext context = new UIContext(window, nkContext, events);

		if (view != null && view instanceof IUIView)
		{
			final IUIView uiView = (IUIView) view;
			final UIPage uiPage = uiView.getCurrentUIPage();
			if (uiPage != null)
			{
				for (final IPanel panel : uiPage.getPanels())
				{
					final var panelAdapter = IUIElementAdapter.adapt(panel);
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
	public void record(VkCommandBuffer vkCommandBuffer, int bindPoint, int index)
	{
		vkCmdBindPipeline(vkCommandBuffer, bindPoint, getPipelineId());

		resources.getVertexBuffer().bind(vkCommandBuffer);

		setViewport(vkCommandBuffer);
		pushConstants(vkCommandBuffer);

		drawer.prepare(bindPoint, graphicContext.getSurfaceManager().getExtent());
		for (final DrawCommandData data : recorder.getDrawCommands())
		{
			drawer.draw(vkCommandBuffer, data);
		}

		dirty = false;
	}

	private void setViewport(VkCommandBuffer commandBuffer)
	{
		final Extent2D extent = graphicContext.getSurfaceManager().getExtent();
		viewport.get(0).set(0, 0, extent.getWidth(), extent.getHeight(), 1, 1);
		vkCmdSetViewport(commandBuffer, 0, viewport);
	}

	private void pushConstants(VkCommandBuffer commandBuffer)
	{
		final var pushAdapter = NuklearConstantsAdapter.adapt(nkPipeline.getPushConstant());
		vkCmdPushConstants(commandBuffer, getPipelineLayout(), VK_SHADER_STAGE_VERTEX_BIT, 0,
				pushAdapter.getData());
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		return NuklearVertexBuffer.VERTEX_DESCRIPTOR;
	}

	@Override
	public AbstractConstants getConstants()
	{
		return nkPipeline.getPushConstant();
	}

	@Override
	public void collectDescriptorSets(List<IVkDescriptorSet> collectIn)
	{
		super.collectDescriptorSets(collectIn);
		collectIn.addAll(resources.getDescriptorSets());
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
		final var rasterizer = new RasterizerImpl();
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
	public int getSubpass()
	{
		return nkPipeline.getSubpass();
	}

	@Override
	protected InputAssembly getInputAssembly()
	{
		return new InputAssemblyImpl();
	}
}
