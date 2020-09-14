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
import org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.util.DeviceResourceFiller;

import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = MemoryChunk.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.MEMORY_CHUNK__PARTS)
public final class MemoryChunkAllocation implements IExtender
{
	private final MemoryChunk memoryChunk;
	private final IAllocationState allocationState;
	private final Memory memory;
	private final DeviceResourceFiller bufferPusher;
	private final boolean useTransfer;

	private boolean needTransfer = false;
	private boolean obsolete = false;

	private MemoryChunkAllocation(final MemoryChunk memoryChunk,
								  final ExecutionContext context,
								  final IAllocationState allocationState,
								  final IObservatoryBuilder observatory)
	{
		this.memoryChunk = memoryChunk;
		this.allocationState = allocationState;

		final var resourcePointers = memoryChunk.getParts()
												.stream()
												.map(p -> p.adapt(IMemoryChunkPartAdapter.class))
												.map(adapter -> adapter.newResource(context));

		final var memoryInfo = new Memory.Info(false, true);
		final var memoryBuilder = new MemoryBuilder(memoryInfo);

		this.memory = memoryBuilder.buildMemory(context, resourcePointers);
		if (DebugUtil.DEBUG_ENABLED) IVulkanDebugService.INSTANCE.register(memory.ptr(), memoryChunk.getName());

		bufferPusher = new DeviceResourceFiller(context);
		useTransfer = memoryChunk.getTransferBuffer() != null;

		observatory.explore(VulkanResourcePackage.MEMORY_CHUNK__PARTS).listenNoParam(this::markObsolete);
	}

	@InjectChildren(index = 0, type = IMemoryChunkPartAllocation.class)
	private void injectChildren(List<IMemoryChunkPartAllocation> memoryPartAllocations)
	{
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

	@Tick(priority = -11)
	private void tick()
	{
		if (needTransfer && !obsolete)
		{
			recordTransfer(false);
			needTransfer = false;
		}
	}

	public void requestUpdate()
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
		return memoryChunk.getParts()
						  .stream()
						  .map(p -> p.adaptNotNull(IMemoryChunkPartAllocation.class))
						  .flatMap(p -> p.streamFillCommands(force));
	}

	public void attach(final IRecordContext recordContext)
	{
		recordContext.lockAllocationDuringExecution(allocationState);
	}

	public void markObsolete()
	{
		obsolete = true;
		allocationState.setAllocationObsolete();
	}

	private void logTransferError()
	{
		final var message = String.format("Transfer  of %s failed (TransferBuffer full ? )", memoryChunk.getName());
		System.out.println(message);
	}

	public Memory.BoundResource getBoundResource(final IMemoryChunkPart memoryPart)
	{
		final int index = partIndex(memoryPart);
		assert index != -1;
		return memory.resources().get(index);
	}

	public Memory getMemory()
	{
		return memory;
	}

	public int partIndex(final IMemoryChunkPart memoryPart)
	{
		return memoryChunk.getParts().indexOf(memoryPart);
	}
}
