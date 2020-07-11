package org.sheepy.lily.vulkan.resource.buffer.transfer.backend;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.transfer.EFlowType;
import org.sheepy.lily.vulkan.core.resource.transfer.IDataFlowCommand;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util.MemorySpace;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util.MemorySpaceManager;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class TransferBufferBackend
{
	private static final String MEMORY_RESERVATION_REJECTED = "MemoryTicket reservation was rejected";

	public final CPUBufferBackend bufferBackend;

	private final List<MemoryTicket> tickets = new ArrayList<>();
	private final List<IDataFlowCommand> commands = new ArrayList<>();
	private final long capacity;
	private final MemorySpaceManager spaceManager;

	private TransferBufferBackend(CPUBufferBackend bufferBackend)
	{
		this.bufferBackend = bufferBackend;
		this.capacity = bufferBackend.info.getInstanceSize();
		spaceManager = new MemorySpaceManager(capacity);
	}

	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
	}

	public MemoryTicket reserveMemory(long size)
	{
		assert size > 0;

		if (size > capacity)
		{
			return MemoryTicket.requestToBig();
		}
		else
		{
			return spaceManager.reserveMemory(size)
							   .map(space -> buildMemoryTicket(space, size))
							   .orElseGet(MemoryTicket::noSpaceLeft);
		}
	}

	private MemoryTicket buildMemoryTicket(final MemorySpace space, final long size)
	{
		final MemoryTicket res;
		final long position = space.getOffset();
		final long memoryPtr = bufferBackend.getMemoryMap() + position;
		final long bufferOffset = bufferBackend.getInstanceOffset() + position;

		res = newSuccessTicket(space, memoryPtr, bufferOffset, size);

		tickets.add(res);
		return res;
	}

	public void releaseTicket(MemoryTicket ticket)
	{
		spaceManager.releaseMemory(ticket.memorySpace);
	}

	public void addTransferCommand(IDataFlowCommand command)
	{
		assert checkMemoryReservation(command);
		commands.add(command);
	}

	public boolean isEmpty()
	{
		return commands.isEmpty();
	}

	public void flush(RecordContext context, final VkDevice vkDevice)
	{
		final int instance = bufferBackend.getCurrentInstance();
		final var res = new FlushRecord(vkDevice, bufferBackend, instance, commands);
		clear(vkDevice);
		res.flush(context);
	}

	private void clear(VkDevice vkDevice)
	{
		for (int i = 0; i < tickets.size(); i++)
		{
			final var ticket = tickets.get(i);
			ticket.invalidate();
		}

		bufferBackend.nextInstance(vkDevice);
		commands.clear();
		spaceManager.clear();
		tickets.clear();
	}

	private MemoryTicket newSuccessTicket(MemorySpace space, long memoryPtr, long bufferOffset, long size)
	{
		return new MemoryTicket(IMemoryTicket.EReservationStatus.SUCCESS,
								space,
								bufferBackend.getAddress(),
								memoryPtr,
								bufferOffset,
								size);
	}

	private static boolean checkMemoryReservation(final IDataFlowCommand command)
	{
		if (command.getMemoryTicket().getReservationStatus() == IMemoryTicket.EReservationStatus.FLUSHED)
		{
			throw new IllegalStateException(MEMORY_RESERVATION_REJECTED);
		}
		else if (command.getMemoryTicket().getReservationStatus() != IMemoryTicket.EReservationStatus.SUCCESS)
		{
			throw new IllegalStateException(MEMORY_RESERVATION_REJECTED);
		}
		return true;
	}

	private static final class FlushRecord
	{
		private final VkDevice vkDevice;
		private final CPUBufferBackend bufferBackend;
		private final List<IDataFlowCommand> commands;

		private final boolean containingFetchCommand;
		private final int instance;

		public FlushRecord(VkDevice vkDevice,
						   CPUBufferBackend bufferBackend,
						   int instance,
						   Collection<IDataFlowCommand> commands)
		{
			this.vkDevice = vkDevice;
			this.bufferBackend = bufferBackend;
			this.instance = instance;
			this.commands = List.copyOf(commands);

			final boolean containingPushCommand = containsType(commands, EFlowType.PUSH);
			containingFetchCommand = containsType(commands, EFlowType.FETCH);

			if (containingPushCommand)
			{
				try (final var stack = MemoryStack.stackPush())
				{
					bufferBackend.flush(stack, vkDevice, instance);
				}
			}
		}

		public void flush(RecordContext recordContext)
		{
			final var commandBuffer = recordContext.commandBuffer;

			try (final MemoryStack stack = MemoryStack.stackPush())
			{
				if (containingFetchCommand)
				{
					recordContext.listenExecution(() -> invalidate(instance));
				}

				for (int i = 0; i < commands.size(); i++)
				{
					final var command = commands.get(i);
					// System.out.println(command.toString());
					command.execute(stack, commandBuffer);
					final var postAction = command.getPostAction();
					if (postAction != null)
					{
						recordContext.listenExecution(() -> postAction.accept(command.getMemoryTicket()));
					}
				}
			}
		}

		private void invalidate(int instance)
		{
			try (final MemoryStack stack = MemoryStack.stackPush())
			{
				bufferBackend.invalidate(stack, vkDevice, instance);
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

	public static final class Builder
	{
		private final long capacity;
		private final int instanceCount;
		private final boolean usedToPush;
		private final boolean usedToFetch;

		public Builder(long capacity, int instanceCount, boolean usedToPush, boolean usedToFetch)
		{
			this.capacity = capacity;
			this.instanceCount = instanceCount;
			this.usedToPush = usedToPush;
			this.usedToFetch = usedToFetch;
		}

		public TransferBufferBackend build(ExecutionContext context)
		{
			final int pushUsage = usedToPush ? EBufferUsage.TRANSFER_SRC_BIT_VALUE : 0;
			final int fetchUsage = usedToFetch ? EBufferUsage.TRANSFER_DST_BIT_VALUE : 0;
			final int usage = pushUsage | fetchUsage;
			final var info = new BufferInfo(capacity, usage, true, false, instanceCount);
			final var bufferBuilder = new CPUBufferBackend.Builder(info);
			final var bufferBackend = bufferBuilder.build(context);
			return new TransferBufferBackend(bufferBackend);
		}
	}
}
