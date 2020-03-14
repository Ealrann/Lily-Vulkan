package org.sheepy.lily.vulkan.nuklear.pipeline;

import org.joml.Vector2ic;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Observe;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.game.api.window.IWindowListener;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.lily.vulkan.nuklear.pipeline.layout.LayoutManager;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

import java.util.ArrayList;
import java.util.List;

@Statefull
@Adapter(scope = NuklearLayoutTask.class, lazy = false)
public final class NuklearLayoutTaskAdapter implements IPipelineTaskAdapter<NuklearLayoutTask>,
													   IAllocableAdapter<IGraphicContext>
{
	private final NuklearLayoutTask task;
	private final GraphicsPipeline pipeline;
	private final IWindowListener.ISizeListener resizeListener = this::onResize;
	private final UI ui;
	private final LayoutManager layoutManager;
	private final List<IPanelAdapter> panelAdapters = new ArrayList<>();

	private IGraphicContext context;
	private ELayoutRequest layoutRequested = ELayoutRequest.None;
	private NuklearContextAdapter nuklearContextAdapter;
	private Window window;

	enum ELayoutRequest
	{
		None,
		Force,
		IfNecessary
	}

	public NuklearLayoutTaskAdapter(NuklearLayoutTask task)
	{
		this.task = task;
		pipeline = ModelUtil.findParent(task, GraphicsPipeline.class);
		final var subpass = ModelUtil.findParent(pipeline, Subpass.class);
		ui = (UI) subpass.getScenePart();
		layoutManager = new LayoutManager();
	}

	@Observe
	private void observe(IObservatoryBuilder observatory)
	{
		observatory.focus(ui)
				   .explore(UiPackage.Literals.UI__CURRENT_UI_PAGE)
				   .explore(UiPackage.Literals.UI_PAGE__PANELS)
				   .adapt(IPanelAdapter.class)
				   .listenAdd(this::addPanelAdapter)
				   .listenRemove(this::removePanelAdapter);
	}

	private void addPanelAdapter(IPanelAdapter adapter)
	{
		panelAdapters.add(adapter);
		layoutRequested = ELayoutRequest.Force;
	}

	private void removePanelAdapter(IPanelAdapter adapter)
	{
		layoutRequested = ELayoutRequest.Force;
		panelAdapters.remove(adapter);
	}

	@Load
	public void load()
	{
		nuklearContextAdapter = task.getContext().adaptNotNull(NuklearContextAdapter.class);

		final int imageCount = ui.getImages().size();

		final var specializationBuffer = BufferUtils.createByteBuffer(4);
		specializationBuffer.putInt(imageCount);
		specializationBuffer.flip();

		final var constantBuffer = VulkanResourceFactory.eINSTANCE.createConstantBuffer();
		constantBuffer.setData(specializationBuffer);

		pipeline.getResourcePkg().getResources().add(constantBuffer);
		pipeline.setSpecializationData(constantBuffer);
	}

	private void onResize(Vector2ic size)
	{
		requestLayout(true);
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		this.context = context;
		window = context.getWindow();
		window.addListener(resizeListener);
		requestLayout(true);
	}

	@Override
	public void free(IGraphicContext context)
	{
		window.removeListener(resizeListener);
		this.context = null;
	}

	public void requestLayout(boolean full)
	{
		if (layoutRequested != ELayoutRequest.Force)
		{
			layoutRequested = (full ? ELayoutRequest.Force : ELayoutRequest.IfNecessary);
		}
	}

	@Override
	public void update(NuklearLayoutTask task, int index)
	{
		if (isLayoutNecessary())
		{
			layout();
			layoutRequested = ELayoutRequest.None;
		}
	}

	private void layout()
	{
		final var nkContext = nuklearContextAdapter.getNkContext();
		final var font = task.getContext().getFont();
		final var fontAdapter = font.adaptNotNull(NuklearFontAdapter.class);
		final var defaultFont = fontAdapter.defaultFont;
		final var fontMap = fontAdapter.fontMap;
		final var extent = context.getSurfaceManager().getExtent();

		try (final var stack = MemoryStack.stackPush())
		{
			final var uiContext = new UIContext(window, nkContext, fontMap, defaultFont, stack);
			layoutManager.layout(panelAdapters, uiContext, extent);
		}
	}

	private boolean isLayoutNecessary()
	{
		switch (layoutRequested)
		{
			case Force:
				return true;
			case IfNecessary:
				return doesPanelNeedLayout();
			default:
				return false;
		}
	}

	public boolean doesPanelNeedLayout()
	{
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			if (panelAdapter.needLayout())
			{
				return true;
			}
		}
		return false;
	}

	public IPanel getHoveredPanel()
	{
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			if (panelAdapter.isHovered())
			{
				return panelAdapter.getPanel();
			}
		}
		return null;
	}

	@Override
	public void record(NuklearLayoutTask task, IRecordContext context)
	{
		layoutManager.setDirty(false);
	}

	@Override
	public boolean needRecord(NuklearLayoutTask task, int index)
	{
		return layoutManager.isDirty();
	}

	public boolean isDirty()
	{
		return layoutManager.isDirty();
	}

	public boolean isFrameStarted()
	{
		return layoutManager.hasStartedFrame();
	}

	public void clearFrame()
	{
		assert layoutManager.hasStartedFrame();
		nuklearContextAdapter.clearFrame();
		layoutManager.setStartedFrame(false);
	}

	public Vector2ic getExtent()
	{
		return layoutManager.getCurrentExtent();
	}
}
