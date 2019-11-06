package org.sheepy.lily.vulkan.nuklear.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lwjgl.nuklear.NkImage;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.api.util.AdapterSetRegistry;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.nuklear.draw.DrawTaskMaintainer;
import org.sheepy.lily.vulkan.nuklear.pipeline.util.NuklearImageInstaller;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;
import org.sheepy.vulkan.surface.Extent2D;
import org.sheepy.vulkan.window.Window;

@Statefull
@Adapter(scope = NuklearLayoutTask.class, lazy = false)
public final class NuklearLayoutTaskAdapter
		implements IPipelineTaskAdapter<NuklearLayoutTask>, IAllocableAdapter<IGraphicContext>
{
	private final AdapterSetRegistry<IPanelAdapter> PANEL_REGISTRY = new AdapterSetRegistry<>(	IPanelAdapter.class,
																								List.of(ApplicationPackage.Literals.APPLICATION__CURRENT_VIEW,
																										PresentationPackage.Literals.IUI_VIEW__CURRENT_UI_PAGE,
																										PresentationPackage.Literals.UI_PAGE__PANELS));

	private final DrawTaskMaintainer drawTaskMaintainer;
	private final NuklearLayoutTask task;

	private boolean dirty = true;
	private boolean vertexUpdated = false;
	private IGraphicContext context;

	private Extent2D currentExtent;
	private NuklearContextAdapter nuklearContextAdapter;
	private Window window;
	private Application application;
	private NuklearImageInstaller imageInstaller = null;

	public NuklearLayoutTaskAdapter(NuklearLayoutTask task)
	{
		this.task = task;

		final var drawTask = task.getDrawTask();
		final var vertexBuffer = task.getVertexBuffer();

		drawTaskMaintainer = new DrawTaskMaintainer(drawTask, vertexBuffer);
	}

	@Load
	public void load()
	{
		application = ModelUtil.getApplication(task);
		PANEL_REGISTRY.startRegister(application);
		setupImageCapability();
	}

	@Dispose
	public void dispose()
	{
		PANEL_REGISTRY.stopRegister(application);
	}

	private void setupImageCapability()
	{
		final List<PathResource> imagePaths = collectImages();
		final var imageArray = task.getImageArray();
		if (imageArray != null && imagePaths.isEmpty() == false)
		{
			final var pipeline = (GraphicsPipeline) task.eContainer().eContainer();
			imageInstaller = new NuklearImageInstaller(pipeline, imagePaths, imageArray);
		}
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		this.context = context;
		window = context.getWindow();
		nuklearContextAdapter = task.getContext().adaptNotNull(NuklearContextAdapter.class);

		// Prepare a first render before the opening of the window
		layout(List.of());
	}

	private List<PathResource> collectImages()
	{
		final List<PathResource> images = new ArrayList<>();

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
		this.context = null;
	}

	public void layout(List<IInputEvent> events)
	{
		final var nkContext = nuklearContextAdapter.getNkContext();
		final var uiContext = new UIContext(window, nkContext, getImageMap(), events);

		final var extent = context.getSurfaceManager().getExtent();
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

	private Map<PathResource, NkImage> getImageMap()
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
	public void update(NuklearLayoutTask task)
	{
		// if (nk_item_is_any_active(nkContext))
		// {
		// dirty = true;
		// }

		if (dirty)
		{
			final var transferBuffer = task.getTransferBuffer();
			final var transferBufferAdapter = transferBuffer.adaptNotNull(ITransferBufferAdapter.class);
			final var stagingBuffer = transferBufferAdapter.getTransferBufferBackend();
			final var vertexBuffer = task.getVertexBuffer();

			vertexUpdated = nuklearContextAdapter.fillVertexBuffer(stagingBuffer, vertexBuffer);

			if (vertexUpdated == true)
			{
				final var commands = nuklearContextAdapter.prepareDrawCommands();
				drawTaskMaintainer.reloadTasks(commands, currentExtent);
			}
			else
			{
				vertexUpdated = false;
			}

			// Print vertex buffer
			//
			// final var backend = ((StagingBuffer) stagingBuffer).bufferBackend;
			// NuklearVertexDescriptor.dumpVertex(backend.getMemoryMap(),
			// NuklearVertexBuffer.VERTEX_BUFFER_SIZE);
			//
			// NuklearVertexDescriptor.dumpIndex(
			// backend.getMemoryMap() + NuklearVertexBuffer.VERTEX_BUFFER_SIZE - 24,
			// f NuklearVertexBuffer.INDEX_BUFFER_SIZE);
		}

		nuklearContextAdapter.clearFrame();
	}

	@Override
	public void record(NuklearLayoutTask task, RecordContext context)
	{
		dirty = !vertexUpdated;
	}

	@Override
	public boolean needRecord(NuklearLayoutTask task, int index)
	{
		return dirty;
	}
}
