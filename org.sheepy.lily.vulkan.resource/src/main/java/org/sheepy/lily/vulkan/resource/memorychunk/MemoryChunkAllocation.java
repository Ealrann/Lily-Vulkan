package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.DeviceResourceFiller;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;

import java.util.List;

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
	private final DeviceResourceFiller bufferPusher;
	private final boolean useTransfer;

	private boolean needTransfer = false;

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
			partAllocation.registerMemory(builder);
		}
		this.memory = builder.build(context);
		bufferPusher = new DeviceResourceFiller(context);
		useTransfer = memoryChunk.getTransferBuffer() != null;

		for (final var partAllocation : memoryPartAllocations)
		{
			final var focus = observatory.focus(partAllocation);
			focus.listenNoParam(this::requestUpdate, IMemoryChunkPartAllocation.Features.PushRequest);
			focus.listen(this::attach, IMemoryChunkPartAllocation.Features.Attach);
		}

		if (useTransfer)
		{
			recordTransfer(true);
		}
		else
		{
			pushData(true);
		}
	}

	@Free
	private void free(ExecutionContext context)
	{
		memory.free(context);
	}

	private void requestUpdate()
	{
		if (useTransfer)
		{
			needTransfer = true;
		}
		else
		{
			allocationState.requestUpdate();
		}
	}

	@Tick(priority = -11)
	private void tick()
	{
		if (needTransfer)
		{
			recordTransfer(false);
			needTransfer = false;
		}
	}

	@Update
	private void updateIfUnlocked()
	{
		pushData(false);
	}

	private void pushData(boolean force)
	{
		final var commands = streamFillCommands(force, true);
		bufferPusher.fillData(commands.fillCommands(), commands.size());
	}

	private void recordTransfer(boolean force)
	{
		final var commands = streamFillCommands(force, false);
		final var transferBuffer = memoryChunk.getTransferBuffer();
		final var transferBufferAllocation = transferBuffer.adapt(TransferBufferAllocation.class);
		final boolean res = transferBufferAllocation.queueFillCommands(commands.fillCommands());
		if (!res && DebugUtil.DEBUG_ENABLED)
		{
			logTransferError();
		}
	}

	private IMemoryChunkPartAllocation.PushData streamFillCommands(boolean force, boolean computeSize)
	{
		return memoryPartAllocations.stream()
									.map(p -> p.gatherPushData(force, computeSize))
									.reduce(IMemoryChunkPartAllocation.PushData::merge)
									.orElse(IMemoryChunkPartAllocation.PushData.EMPTY);
	}

	public void attach(final IRecordContext recordContext)
	{
		recordContext.lockAllocationDuringExecution(allocationState);
	}

	private void logTransferError()
	{
		final var message = String.format("Transfer  of %s failed (TransferBuffer full ? )", memoryChunk.getName());
		System.out.println(message);
	}
}
