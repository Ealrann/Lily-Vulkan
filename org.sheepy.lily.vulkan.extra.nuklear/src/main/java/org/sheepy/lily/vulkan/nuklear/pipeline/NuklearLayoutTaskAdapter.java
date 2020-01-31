package org.sheepy.lily.vulkan.nuklear.pipeline;

import org.joml.Vector2ic;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.util.AdapterSetRegistry;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.window.IWindowListener.ISizeListener;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.common.window.Extent2D;
import org.sheepy.lily.vulkan.common.window.Window;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.nuklear.pipeline.layout.LayoutManager;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

import java.util.List;

@Statefull
@Adapter(scope = NuklearLayoutTask.class, lazy = false)
public final class NuklearLayoutTaskAdapter
		implements IPipelineTaskAdapter<NuklearLayoutTask>, IAllocableAdapter<IGraphicContext>
{
	private final AdapterSetRegistry<IPanelAdapter> panelRegistry = new AdapterSetRegistry<>(IPanelAdapter.class,
																							 List.of(UiPackage.Literals.UI__CURRENT_UI_PAGE,
																									 UiPackage.Literals.UI_PAGE__PANELS));

	private final NuklearLayoutTask task;
	private final GraphicsPipeline pipeline;
	private final ISizeListener resizeListener = this::onResize;
	private final UI ui;

	private IGraphicContext context;
	private LayoutManager layoutManager;
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
	}

	@Load
	public void load()
	{
		nuklearContextAdapter = task.getContext().adaptNotNull(NuklearContextAdapter.class);
		panelRegistry.startRegister(ui);

		final int imageCount = ui.getImages().size();

		final var specializationBuffer = BufferUtils.createByteBuffer(4);
		specializationBuffer.putInt(imageCount);
		specializationBuffer.flip();

		final var constantBuffer = ResourceFactory.eINSTANCE.createConstantBuffer();
		constantBuffer.setData(specializationBuffer);

		pipeline.getResourcePkg().getResources().add(constantBuffer);
		pipeline.setSpecializationData(constantBuffer);

		layoutManager = new LayoutManager(panelRegistry);
	}

	@Dispose
	public void dispose()
	{
		panelRegistry.stopRegister(ui);
		layoutManager = null;
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
		layoutRequested = (full ? ELayoutRequest.Force : ELayoutRequest.IfNecessary);
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

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			final var uiContext = new UIContext(window, nkContext, fontMap, defaultFont, stack);
			layoutManager.layout(uiContext, extent);
		}
	}

	private boolean isLayoutNecessary()
	{
		switch (layoutRequested)
		{
			case Force:
				return true;
			case IfNecessary:
				return layoutManager.needLayout();
			default:
				return false;
		}
	}

	public IPanel getHoveredPanel()
	{
		final var panelAdapters = panelRegistry.getAdapters();
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			if (panelAdapter.isHovered())
			{
				return (IPanel) panelRegistry.getObjects().get(i);
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

	public Extent2D getExtent()
	{
		return layoutManager.getCurrentExtent();
	}
}
