package org.sheepy.lily.vulkan.resource.buffer.transfer;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.ITransferBufferAllocation;
import org.sheepy.lily.vulkan.core.resource.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.TransferBufferBackend;
import org.sheepy.lily.vulkan.resource.buffer.transfer.util.TransferCommandInserter;

import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = TransferBuffer.class)
@Allocation(context = ExecutionContext.class)
public class TransferBufferAllocation extends Notifier<ITransferBufferAllocation.Features> implements
																						   ITransferBufferAllocation
{
	private final TransferBufferBackend backendBuffer;
	private final VkDevice vkDevice;
	private final TransferCommandInserter commandInserter;

	public TransferBufferAllocation(TransferBuffer transferBuffer, ExecutionContext context)
	{
		super(List.of(Features.TransferQueueChange));

		this.vkDevice = context.getVkDevice();
		final long size = transferBuffer.getSize();
		final boolean usedToPush = transferBuffer.isUsedToPush();
		final boolean usedToFetch = transferBuffer.isUsedToFetch();

		final var bufferBuilder = new TransferBufferBackend.Builder(size, usedToPush, usedToFetch);
		backendBuffer = bufferBuilder.build(context);
		commandInserter = new TransferCommandInserter(backendBuffer);
	}

	@Free
	public void free(ExecutionContext context)
	{
		backendBuffer.free(context);
	}

	public boolean queueFillCommands(Stream<FillCommand> commands)
	{
		final var result = commandInserter.queueCommands(commands);
		if (result) notify(Features.TransferQueueChange);
		return result;
	}

	@Override
	public boolean isEmpty()
	{
		return backendBuffer.isEmpty();
	}

	@Override
	public void flush(RecordContext context)
	{
		if (isEmpty() == false)
		{
			backendBuffer.recordFlush(context, vkDevice);
			notify(Features.TransferQueueChange);
		}
	}
}
