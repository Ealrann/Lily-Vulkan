package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.DeviceBufferFiller;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.lwjgl.vulkan.VK10.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;

@ModelExtender(scope = MemoryChunk.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(allocateBeforeParent = true, features = VulkanResourcePackage.MEMORY_CHUNK__PARTS)
@AllocationDependency(features = VulkanResourcePackage.MEMORY_CHUNK__PARTS, type = IMemoryChunkPartAllocation.class)
public final class MemoryChunkAllocation implements IExtender
{
	private final MemoryChunk memoryChunk;
	private final IAllocationState allocationState;
	private final List<IMemoryChunkPartAllocation> memoryPartAllocations;
	private final Memory memory;
	private final DeviceBufferFiller bufferPusher;

	private final List<Integer> usedInRecords = new ArrayList<>();

	private MemoryChunkAllocation(MemoryChunk memoryChunk,
								  ExecutionContext context,
								  IAllocationState allocationState,
								  IObservatoryBuilder observatory,
								  @InjectDependency(index = 0) List<IMemoryChunkPartAllocation> memoryPartAllocations)
	{
		this.memoryChunk = memoryChunk;
		this.allocationState = allocationState;
		this.memoryPartAllocations = memoryPartAllocations;
		final var builder = new MemoryBuilder(context, VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		for (final var partAllocation : memoryPartAllocations)
		{
			final var bufferBackend = partAllocation.getBackend();
			builder.registerBuffer(bufferBackend.getAddress(), bufferBackend::bindBufferMemory);
		}
		this.memory = builder.build(context);
		bufferPusher = new DeviceBufferFiller(context);

		for (final var partAllocation : memoryPartAllocations)
		{
			final var focus = observatory.focus(partAllocation);
			focus.listenNoParam(allocationState::requestUpdate, IMemoryChunkPartAllocation.Features.PushRequest);
			focus.listen(this::attach, IMemoryChunkPartAllocation.Features.Attach);
		}

		pushData();
	}

	@Free
	private void free(ExecutionContext context)
	{
		memory.free(context);
	}

	@Update
	private void pushData()
	{
		final var commands = memoryPartAllocations.stream()
												  .map(IMemoryChunkPartAllocation::gatherPartsToPush)
												  .flatMap(Collection::stream)
												  .collect(Collectors.toUnmodifiableList());

		if (!commands.isEmpty())
		{
			final boolean pushed = tryPushWithTransferBuffer(commands);
			if (!pushed)
			{
				bufferPusher.fillData(commands);
			}
		}
	}

	private boolean tryPushWithTransferBuffer(List<FillCommand> commands)
	{
		final var transferBuffer = memoryChunk.getTransferBuffer();
		if (transferBuffer != null)
		{
			final var transferBufferAllocation = transferBuffer.adapt(TransferBufferAllocation.class);
			final boolean res = transferBufferAllocation.pushFillCommands(commands);
			if (!res && DebugUtil.DEBUG_ENABLED)
			{
				logCompatibilityTransfer();
			}
			return res;
		}
		else
		{
			return false;
		}
	}

	private void logCompatibilityTransfer()
	{
		final var message = String.format("Transfer %s in compatibility mode (TransferBuffer full ? )",
										  memoryChunk.getName());
		System.out.println(message);
	}

	public void attach(final IRecordContext recordContext)
	{
		final Integer code = recordContext.hashCode();

		allocationState.lockAllocation();
		if (!usedInRecords.contains(code))
		{
			usedInRecords.add(code);
			recordContext.listenExecution(() -> this.executionDone(code));
		}
	}

	private void executionDone(Integer code)
	{
		assert usedInRecords.contains(code);
		usedInRecords.remove(code);
		if (usedInRecords.isEmpty())
		{
			allocationState.unlockAllocation();
		}
	}
}
