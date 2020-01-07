package org.sheepy.vulkan.resource.staging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.staging.IDataFlowCommand.EFlowType;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket.EReservationStatus;
import org.sheepy.vulkan.resource.staging.memory.MemorySpaceManager;
import org.sheepy.vulkan.resource.staging.memory.MemorySpaceManager.MemorySpace;

public class TransferBufferBackend implements IAllocable<IExecutionContext>, ITransferBuffer
{
	private static final String MEMORY_RESERVATION_REJECTED = "MemoryTicket reservation was rejected";

	public final CPUBufferBackend bufferBackend;

	private final List<MemoryTicket> tickets = new ArrayList<>();
	private final List<IDataFlowCommand> commands = new ArrayList<>();
	private final long capacity;
	private final MemorySpaceManager spaceManager;

	private IExecutionContext executionContext;

	public TransferBufferBackend(	long capacity,
									int instanceCount,
									boolean usedToPush,
									boolean usedToFetch)
	{
		this.capacity = capacity;
		spaceManager = new MemorySpaceManager(capacity);

		final int pushUsage = usedToPush ? EBufferUsage.TRANSFER_SRC_BIT_VALUE : 0;
		final int fetchUsage = usedToFetch ? EBufferUsage.TRANSFER_DST_BIT_VALUE : 0;
		final int usage = pushUsage | fetchUsage;

		final var info = new BufferInfo(capacity, usage, true, instanceCount);
		bufferBackend = new CPUBufferBackend(info, false);
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		this.executionContext = context;
		bufferBackend.allocate(context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		bufferBackend.free(context);
	}

	@Override
	public MemoryTicket reserveMemory(long size)
	{
		assert size > 0;

		MemoryTicket res = null;

		if (size > capacity)
		{
			res = newFailTicket(EReservationStatus.ERROR__REQUEST_TOO_BIG);
		}
		else
		{
			final var space = spaceManager.reserveMemory(size);

			if (space == null)
			{
				res = newFailTicket(EReservationStatus.FAIL__NO_SPACE_LEFT);
			}
			else
			{
				final long position = space.getOffset();
				final long memoryPtr = bufferBackend.getMemoryMap() + position;
				final long bufferOffset = bufferBackend.getInstanceOffset() + position;

				res = newSuccessTicket(space, memoryPtr, bufferOffset, size);

				tickets.add(res);
			}
		}

		return res;
	}

	@Override
	public void releaseTicket(MemoryTicket ticket)
	{
		spaceManager.releaseMemory(ticket.memorySpace);
	}

	@Override
	public void addTransferCommand(IDataFlowCommand command)
	{
		if (command.getMemoryTicket().getReservationStatus() == EReservationStatus.FLUSHED)
		{
			throw new IllegalStateException(MEMORY_RESERVATION_REJECTED);
		}
		else if (command.getMemoryTicket().getReservationStatus() != EReservationStatus.SUCCESS)
		{
			throw new IllegalStateException(MEMORY_RESERVATION_REJECTED);
		}

		commands.add(command);
	}

	@Override
	public boolean isEmpty()
	{
		return commands.isEmpty();
	}

	@Override
	public IFlushRecorder recordFlush()
	{
		final var logicalDevice = executionContext.getLogicalDevice();
		final int instance = bufferBackend.getCurrentInstance();
		final var res = new FlushRecord(logicalDevice, bufferBackend, instance, commands);
		clear();
		return res;
	}

	private void clear()
	{
		for (int i = 0; i < tickets.size(); i++)
		{
			final var ticket = tickets.get(i);
			ticket.invalidate();
		}

		bufferBackend.nextInstance();
		commands.clear();
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
		return new MemoryTicket(EReservationStatus.SUCCESS,
								space,
								bufferBackend.getAddress(),
								memoryPtr,
								bufferOffset,
								size);
	}

	private static final class FlushRecord implements IFlushRecorder
	{
		private final LogicalDevice logicalDevice;
		private final CPUBufferBackend bufferBackend;
		private final List<IDataFlowCommand> commands;

		private final boolean containingPushCommand;
		private final boolean containingFetchCommand;
		private final int instance;

		public FlushRecord(	LogicalDevice logicalDevice,
							CPUBufferBackend bufferBackend,
							int instance,
							Collection<IDataFlowCommand> commands)
		{
			this.logicalDevice = logicalDevice;
			this.bufferBackend = bufferBackend;
			this.instance = instance;
			this.commands = List.copyOf(commands);

			containingPushCommand = containsType(commands, EFlowType.PUSH);
			containingFetchCommand = containsType(commands, EFlowType.FETCH);

			if (containingPushCommand)
			{
				try (MemoryStack stack = MemoryStack.stackPush())
				{
					bufferBackend.flush(stack, logicalDevice, instance);
				}
			}
		}

		@Override
		public void flush(RecordContext context)
		{
			final var commandBuffer = context.commandBuffer;

			try (final MemoryStack stack = MemoryStack.stackPush())
			{
				if (containingFetchCommand)
				{
					context.addListener(() -> invalidate(instance));
				}

				for (int i = 0; i < commands.size(); i++)
				{
					final var command = commands.get(i);
					// System.out.println(command.toString());
					command.execute(stack, commandBuffer);
					final var postAction = command.getPostAction();
					if (postAction != null)
					{
						context.addListener(() -> postAction.accept(command.getMemoryTicket()));
					}
				}
			}
		}

		private void invalidate(int instance)
		{
			try (final MemoryStack stack = MemoryStack.stackPush())
			{
				bufferBackend.invalidate(stack, logicalDevice, instance);
			}
		}

		private static boolean containsType(Collection<IDataFlowCommand> commands, EFlowType type)
		{
			boolean res = false;
			for (final IDataFlowCommand command : commands)
			{
				if (command.getFlowType() == type)
				{
					res = true;
				}
			}
			return res;
		}
	}
}
