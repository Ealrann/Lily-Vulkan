package org.sheepy.vulkan.resource.buffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.execution.ISingleTimeCommand;
import org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier;
import org.sheepy.vulkan.model.barrier.impl.ReferenceBufferBarrierImpl;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.barrier.ReferenceBufferBarrierExecutor;

public class StagingBuffer implements IAllocable, IStagingBuffer
{
	public final CPUBufferBackend bufferBackend;

	private final Map<Long, TransferCommand> commands = new HashMap<>();
	private final Deque<TransferCommand> synchronizedCommands = new ArrayDeque<>();
	private final Deque<TransferCommand> unsynchronizedCommands = new ArrayDeque<>();
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
		final long bufferOffset = bufferBackend.getOffset() + position;

		final var command = new TransferCommand(bufferBackend.getAddress(), bufferOffset, size);
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
	public void pushSynchronized(	long localMemoryAddress,
									long trgAddress,
									long trgOffset,
									EPipelineStage dstStage,
									EAccess dstAccess)
	{
		final var transferCommand = commands.get(localMemoryAddress);
		synchronizedCommands.add(transferCommand);
		transferCommand.setTarget(trgAddress, trgOffset, dstStage, dstAccess);
	}

	@Override
	public void pushUnsynchronized(long localMemoryAddress, long trgAddress, long trgOffset)
	{
		final var transferCommand = commands.get(localMemoryAddress);
		unsynchronizedCommands.add(transferCommand);
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

		while (synchronizedCommands.isEmpty() == false)
		{
			synchronizedCommands.pop().execute(commandBuffer);
		}

		if (unsynchronizedCommands.isEmpty() == false)
		{
			executionContext.execute(new ISingleTimeCommand()
			{
				@Override
				public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
				{
					while (unsynchronizedCommands.isEmpty() == false)
					{
						unsynchronizedCommands.pop().execute(commandBuffer);
					}
				}
			});
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
		private EPipelineStage dstStage = null;
		private EAccess dstAccess = null;

		public TransferCommand(long srcBuffer, long offset, long size)
		{
			this.srcBuffer = srcBuffer;
			this.offset = offset;
			this.size = size;
		}

		public void execute(VkCommandBuffer commandBuffer)
		{
			final ReferenceBufferBarrier barrier = new ReferenceBufferBarrierImpl();
			barrier.setSrcStage(EPipelineStage.TOP_OF_PIPE_BIT);
			barrier.setDstStage(EPipelineStage.TRANSFER_BIT);
			barrier.setBufferAddress(trgBuffer);
			barrier.setSrcAccess(null);
			barrier.setDstAccess(EAccess.TRANSFER_WRITE_BIT);

			final var executor = new ReferenceBufferBarrierExecutor(barrier);
			executor.allocate();
			executor.execute(commandBuffer);
			executor.free();

			BufferUtils.copyBuffer(commandBuffer, srcBuffer, offset, trgBuffer, trgOffset, size);

			if (dstStage != null)
			{
				final ReferenceBufferBarrier trgBarrier = new ReferenceBufferBarrierImpl();
				trgBarrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
				trgBarrier.setDstStage(dstStage);
				trgBarrier.setBufferAddress(trgBuffer);
				trgBarrier.setSrcAccess(EAccess.TRANSFER_WRITE_BIT);
				trgBarrier.setDstAccess(dstAccess);

				final var trgExecutor = new ReferenceBufferBarrierExecutor(trgBarrier);
				trgExecutor.allocate();
				trgExecutor.execute(commandBuffer);
				trgExecutor.free();
			}
		}

		public void setTarget(	long trgBuffer,
								long trgOffset,
								EPipelineStage dstStage,
								EAccess dstAccess)
		{
			this.setTarget(trgBuffer, trgOffset);

			this.dstStage = dstStage;
			this.dstAccess = dstAccess;
		}

		public void setTarget(long trgBuffer, long trgOffset)
		{
			this.trgBuffer = trgBuffer;
			this.trgOffset = trgOffset;
		}
	}
}
