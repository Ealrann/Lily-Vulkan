package org.sheepy.lily.vulkan.nuklear.pipeline;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.model.presentation.IUIView;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IPushBufferAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask;
import org.sheepy.lily.vulkan.nuklear.adapter.IUIElementAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.IUIElementAdapter.UIContext;
import org.sheepy.lily.vulkan.nuklear.draw.DrawTaskBuilder;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;

@Statefull
@Adapter(scope = NuklearLayoutTask.class)
public class NuklearLayoutTaskAdapter
		implements IPipelineTaskAdapter<NuklearLayoutTask>, IAllocableAdapter<IGraphicContext>
{
	private final DrawTaskBuilder drawTaskMaintainer;

	private final NuklearLayoutTask task;

	private boolean dirty = true;
	private IGraphicContext context;

	private NuklearContextAdapter nuklearContextAdapter;

	public NuklearLayoutTaskAdapter(NuklearLayoutTask task)
	{
		this.task = task;

		final var drawTask = task.getDrawTask();
		final var vertexBuffer = task.getVertexBuffer();

		drawTaskMaintainer = new DrawTaskBuilder(drawTask, vertexBuffer);
	}

	@Override
	public void allocate(MemoryStack stack, IGraphicContext context)
	{
		this.context = context;
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
		final var application = VulkanModelUtil.getApplication(task);
		final var view = application.getCurrentView();
		final var nkContext = nuklearContextAdapter.getNkContext();
		final var uiContext = new UIContext(context.getWindow(), nkContext, events);

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
			final var extent = context.getSurfaceManager().getExtent();

			final var pushBuffer = task.getPushBuffer();
			final var pushBufferAdapter = IPushBufferAdapter.adapt(pushBuffer);
			final var stagingBuffer = pushBufferAdapter.getStagingBuffer();
			final var vertexBuffer = task.getVertexBuffer();

			nuklearContextAdapter.fillVertexBuffer(stagingBuffer, vertexBuffer);
			final var commands = nuklearContextAdapter.prepareDrawCommands();
			drawTaskMaintainer.reloadTasks(commands, extent);

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
		dirty = false;
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
