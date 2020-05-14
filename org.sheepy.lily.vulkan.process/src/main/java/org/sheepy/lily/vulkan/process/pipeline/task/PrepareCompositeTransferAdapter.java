package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.resource.buffer.ICompositeBufferAllocation;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@ModelExtender(scope = PrepareCompositeTransfer.class)
@Adapter(singleton = true)
public final class PrepareCompositeTransferAdapter implements IPipelineTaskAdapter<PrepareCompositeTransfer>
{
	@Override
	public void update(PrepareCompositeTransfer task, int index)
	{
		if (task.isPrepareDuringUpdate())
		{
			prepare(task);
		}
	}

	@Override
	public void record(PrepareCompositeTransfer task, IRecordContext context)
	{
		if (task.isPrepareDuringUpdate() == false)
		{
			prepare(task);
		}
	}

	private static void prepare(PrepareCompositeTransfer task)
	{
		final var compositeBuffer = task.getCompositeBuffer();
		final var adapter = compositeBuffer.allocationHandle(ICompositeBufferAllocation.class).get();
		final var mode = task.getMode();

		adapter.recordFlush(mode, task.getTransferBuffer(), task.getParts());
	}

	@Override
	public ECommandStage getStage(PrepareCompositeTransfer task)
	{
		return task.getStage();
	}
}
