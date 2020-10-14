package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAllocation;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

@ModelExtender(scope = FlushTransferBufferTask.class)
@Allocation
@AllocationDependency(features = ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER, type = InternalTransferBufferAllocation.class)
public final class FlushTransferBufferTaskRecorder implements IRecordableExtender
{
	private final IAllocationState allocationState;
	private final InternalTransferBufferAllocation transferBuffer;

	private boolean needRecord;

	public FlushTransferBufferTaskRecorder(IAllocationState allocationState,
										   IObservatoryBuilder observatory,
										   @InjectDependency(index = 0) InternalTransferBufferAllocation transferBuffer)
	{
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
		allocationState.setAllocationObsolete();
	}

	@Override
	public void record(RecordContext context)
	{
		if (needRecord)
		{
			transferBuffer.flush(context);
			allocationState.setAllocationObsolete();
		}
	}
}
