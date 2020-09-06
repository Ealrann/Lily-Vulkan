package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.util.DeviceResourceFiller;

import java.util.List;
import java.util.stream.Stream;

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
	private boolean obsolete = false;

	private MemoryChunkAllocation(final MemoryChunk memoryChunk,
								  final ExecutionContext context,
								  final IAllocationState allocationState,
								  final IObservatoryBuilder observatory,
								  @InjectDependency(index = 0) final List<IMemoryChunkPartAllocation> memoryPartAllocations)
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
		if (DebugUtil.DEBUG_ENABLED) IVulkanDebugService.INSTANCE.register(memory.ptr(), memoryChunk.getName());
		bufferPusher = new DeviceResourceFiller(context);
		useTransfer = memoryChunk.getTransferBuffer() != null;

		for (final var partAllocation : memoryPartAllocations)
		{
			final var focus = observatory.focus(partAllocation);
			focus.listenNoParam(this::requestUpdate, IMemoryChunkPartAllocation.Features.PushRequest);
			focus.listen(this::attach, IMemoryChunkPartAllocation.Features.Attach);
			focus.listen(this::markObsolete, IMemoryChunkPartAllocation.Features.Obsolete);
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
		if (needTransfer && !obsolete)
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

	private void pushData(final boolean force)
	{
		final var commands = streamFillCommands(force);
		bufferPusher.fillData(commands);
	}

	private void recordTransfer(final boolean force)
	{
		final var commands = streamFillCommands(force);
		final var transferBuffer = memoryChunk.getTransferBuffer();
		final var transferBufferAllocation = transferBuffer.adapt(TransferBufferAllocation.class);
		final boolean res = transferBufferAllocation.queueFillCommands(commands);
		if (!res && DebugUtil.DEBUG_ENABLED)
		{
			logTransferError();
		}
	}

	private Stream<FillCommand> streamFillCommands(final boolean force)
	{
		return memoryPartAllocations.stream().flatMap(p -> p.streamFillCommands(force));
	}

	public void attach(final IRecordContext recordContext)
	{
		recordContext.lockAllocationDuringExecution(allocationState);
	}

	private void markObsolete()
	{
		obsolete = true;
		allocationState.setAllocationObsolete();
	}

	private void logTransferError()
	{
		final var message = String.format("Transfer  of %s failed (TransferBuffer full ? )", memoryChunk.getName());
		System.out.println(message);
	}
}
