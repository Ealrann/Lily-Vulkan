package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ICompositeBufferAdapter;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Adapter(scope = PrepareCompositeTransfer.class)
public class PrepareCompositeTransferAdapter
		implements IPipelineTaskAdapter<PrepareCompositeTransfer>
{
	@Override
	public void record(PrepareCompositeTransfer task, RecordContext context)
	{
		final var compositeBuffer = task.getCompositeBuffer();
		final var adapter = compositeBuffer.adapt(ICompositeBufferAdapter.class);

		adapter.prepareFlush(task.getMode(), task.getInstance());
	}

	@Override
	public boolean needRecord(PrepareCompositeTransfer task, int index)
	{
		final var compositeBuffer = task.getCompositeBuffer();
		final var adapter = compositeBuffer.adapt(ICompositeBufferAdapter.class);

		return adapter.needRecord();
	}

	@Override
	public ECommandStage getStage(PrepareCompositeTransfer task)
	{
		return task.getStage();
	}
}
