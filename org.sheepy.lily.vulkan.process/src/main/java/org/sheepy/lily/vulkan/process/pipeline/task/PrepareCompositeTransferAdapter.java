package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.common.resource.buffer.ICompositeBufferAdapter;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Adapter(scope = PrepareCompositeTransfer.class)
public class PrepareCompositeTransferAdapter
		implements IPipelineTaskAdapter<PrepareCompositeTransfer>
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
		final var adapter = compositeBuffer.adapt(ICompositeBufferAdapter.class);
		final var mode = task.getMode();

		adapter.recordFlush(mode, task.getTransferBuffer(), task.getParts());
	}

	@Override
	public ECommandStage getStage(PrepareCompositeTransfer task)
	{
		return task.getStage();
	}
}
