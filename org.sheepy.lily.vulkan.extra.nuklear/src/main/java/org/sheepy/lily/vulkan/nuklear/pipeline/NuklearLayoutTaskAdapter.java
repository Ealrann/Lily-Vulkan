package org.sheepy.lily.vulkan.nuklear.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.lwjgl.nuklear.NkImage;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IPushBufferAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.nuklear.draw.DrawTaskMaintainer;
import org.sheepy.lily.vulkan.nuklear.pipeline.util.NuklearImageInstaller;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IUIElementAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IUIElementAdapter.UIContext;
import org.sheepy.lily.vulkan.nuklear.util.NkUtil;
import org.sheepy.vulkan.surface.Extent2D;
import org.sheepy.vulkan.window.Window;

@Statefull
@Adapter(scope = NuklearLayoutTask.class)
public final class NuklearLayoutTaskAdapter
		implements IPipelineTaskAdapter<NuklearLayoutTask>, IAllocableAdapter<IGraphicContext>
{
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

	@Autorun
	public void load()
	{
		application = ModelUtil.getApplication(task);
		setupImageCapability();
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
		executeOnUIElements((element, adapter) -> adapter.collectImages(images));
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

		executeOnUIElements((element, adapter) -> layoutElement(uiContext, element, adapter));
	}

	private void layoutElement(	final UIContext uiContext,
								IUIElement element,
								IUIElementAdapter adapter)
	{
		dirty |= adapter.layout(uiContext, element);
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
			final var pushBuffer = task.getPushBuffer();
			final var pushBufferAdapter = pushBuffer.adaptNotNull(IPushBufferAdapter.class);
			final var stagingBuffer = pushBufferAdapter.getStagingBuffer();
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

	private void executeOnUIElements(BiConsumer<IUIElement, IUIElementAdapter> consumer)
	{
		final var uiPage = NkUtil.resolveUIPage(application);

		if (uiPage != null)
		{
			final var panels = uiPage.getPanels();
			for (int i = 0; i < panels.size(); i++)
			{
				final var panel = panels.get(i);
				final var panelAdapter = panel.adaptNotNull(IUIElementAdapter.class);
				consumer.accept(panel, panelAdapter);
			}
		}
	}
}
