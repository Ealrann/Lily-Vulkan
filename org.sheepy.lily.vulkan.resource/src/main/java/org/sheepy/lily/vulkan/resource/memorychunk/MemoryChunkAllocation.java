package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.cadence.Tick;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBuffer;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.resource.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.util.DeviceResourceFiller;

import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = MemoryChunk.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = MemoryChunk.FeatureIDs.PARTS)
public final class MemoryChunkAllocation implements IAdapter
{
	private static final MemoryBuilder MEMORY_BUILDER = new MemoryBuilder(new Memory.Info(false, true));

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

		final var resourcePointers = memoryChunk.parts()
											   .stream()
											   .map(p -> p.adapt(IMemoryChunkPartAdapter.class))
											   .map(adapter -> adapter.allocateVulkanResource(context));

		final var debug = DebugUtil.DEBUG_ENABLED;
		this.memory = debug
				? MEMORY_BUILDER.buildDebug(context, resourcePointers, this::throwMemoryCreationException)
				: MEMORY_BUILDER.build(context, resourcePointers);
		if (debug) IVulkanDebugService.INSTANCE.register(memory.ptr(), memoryChunk.name());

		bufferPusher = new DeviceResourceFiller(context);
		useTransfer = memoryChunk.transferBuffer() != null;

		observatory.explore(MemoryChunk.FeatureIDs.PARTS).listenNoParam(this::markObsolete);
	}

	@InjectChildren(index = 0, type = IMemoryChunkPartAllocation.class)
	private void injectChildren(List<IMemoryChunkPartAllocation> memoryPartAllocations)
	{
		if (useTransfer)
		{
			queueTransferCommands(true);
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
			queueTransferCommands(false);
			needTransfer = false;
		}
	}

	public void requestUpdate()
	{
		if (useTransfer) needTransfer = true;
		else allocationState.requestUpdate();
	}

	@org.sheepy.lily.core.api.allocation.annotation.Update
	private void updateIfUnlocked()
	{
		pushData(false);
	}

	private void pushData(final boolean force)
	{
		final var commands = streamFillCommands(force);
		bufferPusher.fillData(commands);
	}

	private void queueTransferCommands(final boolean force)
	{
		final var commands = streamFillCommands(force);
		final var transferBuffer = memoryChunk.transferBuffer();
		final var transferBufferAllocation = transferBuffer.adaptNotNull(TransferBufferAllocation.class);
		final boolean res = transferBufferAllocation.queueFillCommands(commands);
		if (!res && DebugUtil.DEBUG_ENABLED)
		{
			logTransferError();
		}
	}

	private Stream<FillCommand> streamFillCommands(final boolean force)
	{
		return memoryChunk.parts()
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
		final var message = String.format("Transfer of MemoryChunkParts [%s] failed (TransferBuffer full?)",
										  memoryChunk.name());
		System.out.println(message);
	}

	@SuppressWarnings("unchecked")
	public Memory.BoundResource<VkImage> getBoundResource(final StaticImage imageMemory)
	{
		return (Memory.BoundResource<VkImage>) getBoundResource((IMemoryChunkPart) imageMemory);
	}

	@SuppressWarnings("unchecked")
	public Memory.BoundResource<VkImage> getBoundResource(final ImageViewer imageMemory)
	{
		return (Memory.BoundResource<VkImage>) getBoundResource((IMemoryChunkPart) imageMemory);
	}

	@SuppressWarnings("unchecked")
	public Memory.BoundResource<VkBuffer> getBoundResource(final org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory bufferMemory)
	{
		return (Memory.BoundResource<VkBuffer>) getBoundResource((IMemoryChunkPart) bufferMemory);
	}

	public Memory.BoundResource<?> getBoundResource(final IMemoryChunkPart memoryPart)
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
		return memoryChunk.parts().indexOf(memoryPart);
	}

	private void throwMemoryCreationException(final String reason)
	{
		throw new IllegalStateException("Error when allocating Memory [" + memoryChunk.name() + "], reason: " + reason);
	}
}
