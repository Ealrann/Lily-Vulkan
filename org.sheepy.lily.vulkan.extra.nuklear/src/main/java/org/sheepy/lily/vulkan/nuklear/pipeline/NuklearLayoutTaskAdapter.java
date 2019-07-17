package org.sheepy.lily.vulkan.nuklear.pipeline;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.presentation.IUIView;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IPushBufferAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.nuklear.draw.DrawTaskMaintainer;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IUIElementAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.IUIElementAdapter.UIContext;
import org.sheepy.vulkan.surface.Extent2D;
import org.sheepy.vulkan.window.Window;

@Statefull
@Adapter(scope = NuklearLayoutTask.class)
public class NuklearLayoutTaskAdapter
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

	public NuklearLayoutTaskAdapter(NuklearLayoutTask task)
	{
		this.task = task;

		final var drawTask = task.getDrawTask();
		final var vertexBuffer = task.getVertexBuffer();

		drawTaskMaintainer = new DrawTaskMaintainer(drawTask, vertexBuffer);
	}

	@Override
	public void allocate(MemoryStack stack, IGraphicContext context)
	{
		this.context = context;
		window = context.getWindow();
		application = VulkanModelUtil.getApplication(task);
		nuklearContextAdapter = NuklearContextAdapter.adapt(task.getContext());

		// Prepare a first render before the opening of the window
		layout(List.of());
	}

	@Override
	public void free(IGraphicContext context)
	{
		this.context = null;
	}

	public void layout(List<IInputEvent> events)
	{
		final var view = application.getCurrentView();
		final var nkContext = nuklearContextAdapter.getNkContext();
		final var uiContext = new UIContext(window, nkContext, events);

		final var extent = context.getSurfaceManager().getExtent();
		if (extent != currentExtent)
		{
			dirty = true;
			currentExtent = extent;
		}

		if (view != null && view instanceof IUIView)
		{
			final var uiView = (IUIView) view;
			final var uiPage = uiView.getCurrentUIPage();
			if (uiPage != null)
			{
				for (final var panel : uiPage.getPanels())
				{
					final var panelAdapter = IUIElementAdapter.adapt(panel);
					dirty |= panelAdapter.layout(uiContext, panel);
				}
			}
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
			final var pushBufferAdapter = IPushBufferAdapter.adapt(pushBuffer);
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

	@Override
	public boolean isAllocationDirty(IGraphicContext context)
	{
		return false;
	}
}
