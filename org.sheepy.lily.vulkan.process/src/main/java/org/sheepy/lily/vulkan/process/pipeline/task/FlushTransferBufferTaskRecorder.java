package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAllocation;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@ModelExtender(scope = FlushTransferBufferTask.class)
@Allocation
@AllocationDependency(features = ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER, type = InternalTransferBufferAllocation.class)
public final class FlushTransferBufferTaskRecorder implements IPipelineTaskRecorder
{
	private final IAllocationState allocationState;
	private final InternalTransferBufferAllocation transferBuffer;
	private final FlushTransferBufferTask task;

	private boolean needRecord;

	public FlushTransferBufferTaskRecorder(FlushTransferBufferTask task,
										   IAllocationState allocationState,
										   IObservatoryBuilder observatory,
										   @InjectDependency(index = 0) InternalTransferBufferAllocation transferBuffer)
	{
		this.task = task;
		this.allocationState = allocationState;
		this.transferBuffer = transferBuffer;
		this.needRecord = transferBuffer.isEmpty() == false;

		observatory.focus(transferBuffer)
				   .listenNoParam(this::transferQueueChanged,
								  InternalTransferBufferAllocation.Features.TransferQueueChange);
	}

	private void transferQueueChanged()
	{
		needRecord = true;
	}

	@Override
	public void record(RecordContext context)
	{
		if (needRecord)
		{
			final var record = transferBuffer.recordFlush();
			record.flush(context);
			allocationState.setAllocationObsolete();
		}
	}

	@Override
	public ECommandStage getStage()
	{
		return task.getStage();
	}
}
