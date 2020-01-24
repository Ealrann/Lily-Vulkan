package org.sheepy.lily.vulkan.resource.buffer.transfer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.common.resource.IVulkanResourceAdapter;
import org.sheepy.lily.vulkan.common.resource.buffer.InternalTransferBufferAdapter;
import org.sheepy.lily.vulkan.common.util.InstanceCountUtil;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.lily.vulkan.resource.buffer.memory.MemoryTicket;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommandFactory;
import org.sheepy.lily.vulkan.resource.buffer.transfer.internal.TransferBufferBackend;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

@Statefull
@Adapter(scope = TransferBuffer.class)
public class TransferBufferAdapter implements InternalTransferBufferAdapter, IVulkanResourceAdapter
{
	private final TransferBuffer transferBuffer;

	private TransferBufferBackend backendBuffer;

	public TransferBufferAdapter(TransferBuffer transferBuffer)
	{
		this.transferBuffer = transferBuffer;
	}

	@Override
	public void allocate(InternalExecutionContext context)
	{
		final long size = transferBuffer.getSize();
		final int instanceCount = InstanceCountUtil.getInstanceCount(	context,
																		transferBuffer.getInstanceCount());
		final boolean usedToPush = transferBuffer.isUsedToPush();
		final boolean usedToFetch = transferBuffer.isUsedToFetch();

		backendBuffer = new TransferBufferBackend(size, instanceCount, usedToPush, usedToFetch);
		backendBuffer.allocate(context);
	}

	@Override
	public void free(InternalExecutionContext context)
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
	public void newPushCommand(	IMemoryTicket ticket,
								long trgBuffer,
								long trgOffset,
								EPipelineStage srcStage,
								int srcAccess)
	{
		final var pushCommand = DataFlowCommandFactory.newPushCommand(	(MemoryTicket) ticket,
																		trgBuffer,
																		trgOffset,
																		srcStage,
																		srcAccess);
		backendBuffer.addTransferCommand(pushCommand);
	}

	@Override
	public void addTransferCommand(IDataFlowCommand command)
	{
		backendBuffer.addTransferCommand(command);
	}

	@Override
	public boolean isEmpty()
	{
		return backendBuffer.isEmpty();
	}

	@Override
	public IFlushRecorder recordFlush()
	{
		return backendBuffer.recordFlush();
	}
}
