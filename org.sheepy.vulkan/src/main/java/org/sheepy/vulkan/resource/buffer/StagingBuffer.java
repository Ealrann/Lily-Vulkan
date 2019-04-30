package org.sheepy.vulkan.resource.buffer;

import java.util.LinkedHashMap;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public class StagingBuffer implements IAllocable, IStagingBuffer
{
	private final CPUBufferBackend bufferBackend;

	private final Map<Long, TransferCommand> commands = new LinkedHashMap<>();
	private final long capacity;

	private long position = 0;
	private IExecutionContext executionContext;

	private long minMemoryMapAlignment;

	public StagingBuffer(long capacity, int instanceCount)
	{
		this.capacity = capacity;
		final BufferInfo info = new BufferInfo(capacity, EBufferUsage.TRANSFER_SRC_BIT_VALUE, true,
				instanceCount);
		bufferBackend = new CPUBufferBackend(info, false);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		executionContext = (IExecutionContext) context;
		final var physicalDevice = executionContext.getPhysicalDevice();
		minMemoryMapAlignment = physicalDevice.getDeviceProperties().limits()
				.minMemoryMapAlignment();

		bufferBackend.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		bufferBackend.free(context);
	}

	@Override
	public long reserveMemory(long size)
	{
		final long alignedSize = align(size, minMemoryMapAlignment);

		if (position + alignedSize > capacity)
		{
			throw new AssertionError("Staging buffer too small.");
		}

		final long memoryAddress = bufferBackend.getMemoryMap() + position;
		final var command = new TransferCommand(bufferBackend.getAddress(), position, size);
		commands.put(memoryAddress, command);
		position += alignedSize;

		return memoryAddress;
	}

	private static final long align(long index, long alignment)
	{
		final int chunkCount = (int) Math.ceil(((double) index) / alignment);
		return chunkCount * alignment;
	}

	@Override
	public void pushMemoryTo(long localMemoryAddress, long trgAddress, long trgOffset)
	{
		final var transferCommand = commands.get(localMemoryAddress);
		transferCommand.setTarget(trgAddress, trgOffset);
	}

	@Override
	public boolean isEmpty()
	{
		return commands.isEmpty();
	}

	@Override
	public void flush(VkCommandBuffer commandBuffer)
	{
		bufferBackend.flush(executionContext.getLogicalDevice());
		bufferBackend.nextInstance();

		for (final TransferCommand transferCommand : commands.values())
		{
			transferCommand.execute(commandBuffer);
		}

		commands.clear();
		position = 0;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	private class TransferCommand
	{
		private final long srcBuffer;
		private final long offset;
		private final long size;

		private long trgBuffer;
		private long trgOffset;

		public TransferCommand(long srcBuffer, long offset, long size)
		{
			this.srcBuffer = srcBuffer;
			this.offset = offset;
			this.size = size;
		}

		public void execute(VkCommandBuffer commandBuffer)
		{
			BufferUtils.copyBuffer(commandBuffer, srcBuffer, offset, trgBuffer, trgOffset, size);
		}

		public void setTarget(long trgBuffer, long trgOffset)
		{
			this.trgBuffer = trgBuffer;
			this.trgOffset = trgOffset;
		}
	}
}
