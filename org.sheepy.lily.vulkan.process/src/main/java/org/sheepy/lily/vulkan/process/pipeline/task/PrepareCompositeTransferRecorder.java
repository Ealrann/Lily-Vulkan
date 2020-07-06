package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.core.resource.buffer.ICompositeBufferAllocation;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.BufferPart;

import java.util.List;

@ModelExtender(scope = PrepareCompositeTransfer.class)
@Allocation
@AllocationChild(allocateBeforeParent = true, features = ProcessPackage.PREPARE_COMPOSITE_TRANSFER__BUFFER_REFERENCE)
@AllocationDependency(features = ProcessPackage.PREPARE_COMPOSITE_TRANSFER__BUFFER_REFERENCE, type = IBufferReferenceAllocation.class)
public final class PrepareCompositeTransferRecorder implements IRecordableExtender
{
	private final PrepareCompositeTransfer task;
	private final IBufferReferenceAllocation bufferReferenceAllocation;

	private PrepareCompositeTransferRecorder(PrepareCompositeTransfer task,
											 @InjectDependency(index = 0) IBufferReferenceAllocation bufferReferenceAllocation)
	{
		this.task = task;
		this.bufferReferenceAllocation = bufferReferenceAllocation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void record(RecordContext context)
	{
		final var compositeBuffer = task.getCompositeBuffer();
		final var adapter = compositeBuffer.adapt(ICompositeBufferAllocation.class);
		final var mode = task.getMode();
		// TODO any buffer should be accepted here
		final var buffers = (List<BufferPart>) (List<?>) bufferReferenceAllocation.getBuffers(context.index,
																							  context.indexCount);

		adapter.recordFlush(mode, task.getTransferBuffer(), buffers);
	}
}
