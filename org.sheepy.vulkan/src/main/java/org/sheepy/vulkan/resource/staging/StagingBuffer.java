package org.sheepy.vulkan.resource.staging;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.staging.IStagingBuffer.MemoryTicket.EReservationStatus;
import org.sheepy.vulkan.resource.staging.memory.MemorySpaceManager;
import org.sheepy.vulkan.resource.staging.memory.MemorySpaceManager.MemorySpace;

public class StagingBuffer implements IAllocable<IExecutionContext>, IStagingBuffer
{
	public final CPUBufferBackend bufferBackend;

	private final List<MemoryTicket> tickets = new ArrayList<>();
	private final Deque<IDataFlowCommand> synchronizedCommands = new ArrayDeque<>();
	private final Deque<IDataFlowCommand> unsynchronizedCommands = new ArrayDeque<>();
	private final long capacity;
	private final MemorySpaceManager spaceManager;

	private boolean containingPushCommand = false;
	private boolean containingGetCommand = false;
	private IExecutionContext executionContext;
	private long minMemoryMapAlignment;

	public StagingBuffer(long capacity, int instanceCount)
	{
		this.capacity = capacity;
		spaceManager = new MemorySpaceManager(capacity);

		final var info = new BufferInfo(capacity, EBufferUsage.TRANSFER_SRC_BIT_VALUE, true,
				instanceCount);
		bufferBackend = new CPUBufferBackend(info, false);
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		this.executionContext = context;
		final var physicalDevice = context.getPhysicalDevice();
		minMemoryMapAlignment = physicalDevice.getDeviceProperties().limits()
				.minMemoryMapAlignment();

		bufferBackend.allocate(stack, context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		bufferBackend.free(context);
	}

	@Override
	public MemoryTicket reserveMemory(long size)
	{
		MemoryTicket res = null;

		final long alignedSize = align(size, minMemoryMapAlignment);

		if (alignedSize > capacity)
		{
			res = newFailTicket(EReservationStatus.ERROR__REQUEST_TOO_BIG);
		}
		else
		{
			final var space = spaceManager.reserveMemory(alignedSize);

			if (space == null)
			{
				res = newFailTicket(EReservationStatus.FAIL__NO_SPACE_LEFT);
			}
			else
			{
				final long position = space.getOffset();
				final long memoryPtr = bufferBackend.getMemoryMap() + position;
				final long bufferOffset = bufferBackend.getOffset() + position;

				res = newSuccessTicket(space, memoryPtr, bufferOffset, size);

				tickets.add(res);
			}
		}

		return res;
	}

	private static final long align(long index, long alignment)
	{
		final int chunkCount = (int) Math.ceil(((double) index) / alignment);
		return chunkCount * alignment;
	}

	@Override
	public void releaseTicket(MemoryTicket ticket)
	{
		spaceManager.releaseMemory(ticket.memorySpace);
	}

	@Override
	public void addStagingCommand(IDataFlowCommand command)
	{
		if (command.getMemoryTicket().getReservationStatus() == EReservationStatus.FLUSHED)
		{
			throw new IllegalStateException("MemoryTicket reservation was rejected");
		}
		else if (command.getMemoryTicket().getReservationStatus() != EReservationStatus.SUCCESS)
		{
			throw new IllegalStateException("MemoryTicket reservation was rejected");
		}

		switch (command.getFlowType())
		{
		case GET:
			containingGetCommand = true;
			break;
		case PUSH:
			containingPushCommand = true;
			break;
		}

		if (command.isPipelined())
		{
			synchronizedCommands.add(command);
		}
		else
		{
			unsynchronizedCommands.add(command);
		}
	}

	@Override
	public boolean isEmpty()
	{
		return synchronizedCommands.isEmpty() && unsynchronizedCommands.isEmpty();
	}

	@Override
	public void flushCommands(VkCommandBuffer commandBuffer)
	{
		final var logicalDevice = executionContext.getLogicalDevice();

		if (containingPushCommand)
		{
			bufferBackend.flush(logicalDevice);
		}
		bufferBackend.nextInstance();

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			while (synchronizedCommands.isEmpty() == false)
			{
				synchronizedCommands.pop().execute(stack, commandBuffer);
			}
		}

		if (unsynchronizedCommands.isEmpty() == false)
		{
			executionContext.execute((MemoryStack stack, VkCommandBuffer subCommandBuffer) ->
			{
				for (final var command : unsynchronizedCommands)
				{
					command.execute(stack, subCommandBuffer);
				}
			});

			while (unsynchronizedCommands.isEmpty() == false)
			{
				final var command = unsynchronizedCommands.pop();
				final var postAction = command.getPostAction();
				if (postAction != null)
				{
					postAction.accept(command.getMemoryTicket());
				}
			}
		}

		if (containingGetCommand)
		{
			bufferBackend.invalidate(logicalDevice);
		}

		clear();
	}

	private void clear()
	{
		for (int i = 0; i < tickets.size(); i++)
		{
			final var ticket = tickets.get(i);
			ticket.invalidate();
		}

		containingGetCommand = false;
		containingPushCommand = false;
		spaceManager.clear();

		tickets.clear();
	}

	private static MemoryTicket newFailTicket(EReservationStatus failure)
	{
		return new MemoryTicket(failure, null, -1, -1, -1, -1);
	}

	private MemoryTicket newSuccessTicket(	MemorySpace space,
											long memoryPtr,
											long bufferOffset,
											long size)
	{
		return new MemoryTicket(EReservationStatus.SUCCESS, space, bufferBackend.getAddress(),
				memoryPtr, bufferOffset, size);
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}
}
