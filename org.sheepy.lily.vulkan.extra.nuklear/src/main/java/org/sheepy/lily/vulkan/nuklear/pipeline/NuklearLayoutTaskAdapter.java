package org.sheepy.lily.vulkan.nuklear.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joml.Vector2ic;
import org.lwjgl.BufferUtils;
import org.lwjgl.nuklear.NkImage;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.AdapterSetRegistry;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.nuklear.pipeline.util.NuklearImageInstaller;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.surface.Extent2D;
import org.sheepy.vulkan.window.IWindowListener.ISizeListener;
import org.sheepy.vulkan.window.Window;

@Statefull
@Adapter(scope = NuklearLayoutTask.class, lazy = false)
public final class NuklearLayoutTaskAdapter
		implements IPipelineTaskAdapter<NuklearLayoutTask>, IAllocableAdapter<IGraphicContext>
{
	private final AdapterSetRegistry<IPanelAdapter> PANEL_REGISTRY = new AdapterSetRegistry<>(	IPanelAdapter.class,
																								List.of(GraphicPackage.Literals.GRAPHICS_PIPELINE__SCENE_PART,
																										UiPackage.Literals.UI__CURRENT_UI_PAGE,
																										UiPackage.Literals.UI_PAGE__PANELS));

	private final NuklearLayoutTask task;
	private final GraphicsPipeline pipeline;
	private final ISizeListener resizeListener = this::onResize;

	private boolean dirty = true;
	private IGraphicContext context;

	private boolean startedFrame = true;
	private Extent2D currentExtent;
	private NuklearContextAdapter nuklearContextAdapter;
	private Window window;
	private NuklearImageInstaller imageInstaller = null;

	public NuklearLayoutTaskAdapter(NuklearLayoutTask task)
	{
		this.task = task;
		pipeline = ModelUtil.findParent(task, GraphicsPipeline.class);
	}

	@Load
	public void load()
	{
		nuklearContextAdapter = task.getContext().adaptNotNull(NuklearContextAdapter.class);
		PANEL_REGISTRY.startRegister(pipeline);
		setupImageCapability();

		final UI ui = (UI) pipeline.getScenePart();
		final var fontPkg = ui.getFontPkg();
		final int imageCount = imageInstaller != null ? imageInstaller.size() : 0;
		final int fontCount = fontPkg != null ? fontPkg.getFonts().size() : 0;

		final var specializationBuffer = BufferUtils.createByteBuffer(8);
		specializationBuffer.putInt(fontCount);
		specializationBuffer.putInt(imageCount);
		specializationBuffer.flip();

		final var constantBuffer = ResourceFactory.eINSTANCE.createConstantBuffer();
		constantBuffer.setData(specializationBuffer);

		pipeline.getResourcePkg().getResources().add(constantBuffer);
		pipeline.setSpecializationData(constantBuffer);
	}

	@Dispose
	public void dispose()
	{
		PANEL_REGISTRY.stopRegister(pipeline);
	}

	private void setupImageCapability()
	{
		final List<FileResource> imagePaths = collectImages();
		final var imageArray = task.getImageArray();
		if (imageArray != null && imagePaths.isEmpty() == false)
		{
			imageInstaller = new NuklearImageInstaller(pipeline, imagePaths, imageArray);
		}
	}

	private void onResize(Vector2ic size)
	{
		requestLayout();
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		this.context = context;
		window = context.getWindow();
		window.addListener(resizeListener);
		requestLayout();
	}

	private List<FileResource> collectImages()
	{
		final List<FileResource> images = new ArrayList<>();

		final var panelAdapters = PANEL_REGISTRY.getAdapters();
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			panelAdapter.collectImages(images);
		}

		return List.copyOf(images);
	}

	@Override
	public void free(IGraphicContext context)
	{
		window.removeListener(resizeListener);
		this.context = null;
	}

	boolean layoutRequested = false;

	public void requestLayout()
	{
		layoutRequested = true;
	}

	@Override
	public void update(NuklearLayoutTask task, int index)
	{
		if (layoutRequested)
		{
			layout();
			layoutRequested = false;
		}
	}

	private void layout()
	{
		final var nkContext = nuklearContextAdapter.getNkContext();

		final var font = task.getContext().getFont();
		final var fontAdapter = font.adaptNotNull(NuklearFontAdapter.class);
		final var defaultFont = fontAdapter.getDefaultFont();
		final var fontMap = fontAdapter.fontMap;
		final var extent = context.getSurfaceManager().getExtent();
		final var uiContext = new UIContext(window, nkContext, getImageMap(), fontMap, defaultFont);

		startedFrame = true;

		if (extent != currentExtent)
		{
			dirty = true;
			currentExtent = extent;
		}

		final var panelAdapters = PANEL_REGISTRY.getAdapters();
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			dirty |= panelAdapter.layout(uiContext);
		}
	}

	public IPanel getHoveredPanel()
	{
		final var panelAdapters = PANEL_REGISTRY.getAdapters();
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			if (panelAdapter.isHovered())
			{
				return (IPanel) PANEL_REGISTRY.getObjects().get(i);
			}
		}
		return null;
	}

	private Map<FileResource, NkImage> getImageMap()
	{
		if (imageInstaller != null)
		{
			return Map.copyOf(imageInstaller.imageMap());
		}
		else
		{
			return Map.of();
		}
	}

	@Override
	public void record(NuklearLayoutTask task, RecordContext context)
	{
		dirty = false;
	}

	@Override
	public boolean needRecord(NuklearLayoutTask task, int index)
	{
		return dirty;
	}

	public boolean isDirty()
	{
		return dirty;
	}

	public boolean isFrameStarted()
	{
		return startedFrame;
	}

	public void clearFrame()
	{
		assert startedFrame;
		nuklearContextAdapter.clearFrame();
		startedFrame = false;
	}

	public Extent2D getExtent()
	{
		return currentExtent;
	}
}
