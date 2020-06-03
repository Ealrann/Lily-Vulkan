package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.core.resource.buffer.ICompositeBufferAllocation;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@ModelExtender(scope = PrepareCompositeTransfer.class)
@Adapter
public final class PrepareCompositeTransferRecorder implements IPipelineTaskRecorder
{
	private final PrepareCompositeTransfer task;

	private PrepareCompositeTransferRecorder(PrepareCompositeTransfer task)
	{
		this.task = task;
	}

	@Override
	public void update(int index)
	{
		if (task.isPrepareDuringUpdate())
		{
			prepare();
		}
	}

	@Override
	public void record(RecordContext context)
	{
		if (task.isPrepareDuringUpdate() == false)
		{
			prepare();
		}
	}

	@Override
	public boolean isRecordDirty(final int index)
	{
		return false;
	}

	private void prepare()
	{
		final var compositeBuffer = task.getCompositeBuffer();
		final var adapter = compositeBuffer.adapt(ICompositeBufferAllocation.class);
		final var mode = task.getMode();

		adapter.recordFlush(mode, task.getTransferBuffer(), task.getParts());
	}

	@Override
	public ECommandStage getStage()
	{
		return task.getStage();
	}
}
