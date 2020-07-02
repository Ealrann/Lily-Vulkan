package org.sheepy.lily.vulkan.resource.buffer.transfer;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAllocation;
import org.sheepy.lily.vulkan.core.util.InstanceCountUtil;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.lily.vulkan.resource.buffer.memory.MemoryTicket;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommandFactory;
import org.sheepy.lily.vulkan.resource.buffer.transfer.internal.TransferBufferBackend;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;

@ModelExtender(scope = TransferBuffer.class)
@Allocation(context = ExecutionContext.class)
public class TransferBufferAllocation extends Notifier<InternalTransferBufferAllocation.Features> implements
																								  InternalTransferBufferAllocation
{
	private final TransferBufferBackend backendBuffer;
	private final VkDevice vkDevice;

	public TransferBufferAllocation(TransferBuffer transferBuffer, ExecutionContext context)
	{
		super(List.of(Features.TransferQueueChange));

		this.vkDevice = context.getVkDevice();
		final long size = transferBuffer.getSize();
		final int instanceCount = InstanceCountUtil.getInstanceCount(transferBuffer, transferBuffer.getInstanceCount());
		final boolean usedToPush = transferBuffer.isUsedToPush();
		final boolean usedToFetch = transferBuffer.isUsedToFetch();

		final var bufferBuilder = new TransferBufferBackend.Builder(size, instanceCount, usedToPush, usedToFetch);
		backendBuffer = bufferBuilder.build(context);
	}

	@Free
	public void free(ExecutionContext context)
	{
		backendBuffer.free(context);
	}

	@Override
	public IMemoryTicket reserveMemory(long size)
	{
		return backendBuffer.reserveMemory(size);
	}

	@Override
	public void releaseTicket(IMemoryTicket ticket)
	{
		backendBuffer.releaseTicket((MemoryTicket) ticket);
	}

	@Override
	public void newPushCommand(IMemoryTicket ticket,
							   long trgBuffer,
							   long trgOffset,
							   EPipelineStage srcStage,
							   int srcAccess)
	{
		final var pushCommand = DataFlowCommandFactory.newPushCommand((MemoryTicket) ticket,
																	  trgBuffer,
																	  trgOffset,
																	  srcStage,
																	  srcAccess);
		backendBuffer.addTransferCommand(pushCommand);
		notify(Features.TransferQueueChange);
	}

	@Override
	public void addTransferCommand(IDataFlowCommand command)
	{
		backendBuffer.addTransferCommand(command);
		notify(Features.TransferQueueChange);
	}

	@Override
	public boolean isEmpty()
	{
		return backendBuffer.isEmpty();
	}

	@Override
	public IFlushRecorder recordFlush()
	{
		final var flushRecorder = backendBuffer.recordFlush(vkDevice);
		notify(Features.TransferQueueChange);
		return flushRecorder;
	}
}
