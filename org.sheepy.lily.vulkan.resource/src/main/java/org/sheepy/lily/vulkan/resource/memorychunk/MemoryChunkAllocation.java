package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.cadence.Tick;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBuffer;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.resource.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.*;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.util.DeviceResourceFiller;

import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = MemoryChunk.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.MEMORY_CHUNK__PARTS)
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

		final var resourcePointers = memoryChunk.getParts()
												.stream()
												.map(p -> p.adapt(IMemoryChunkPartAdapter.class))
												.map(adapter -> adapter.allocateVulkanResource(context));

		final var debug = DebugUtil.DEBUG_ENABLED;
		this.memory = debug
				? MEMORY_BUILDER.buildDebug(context, resourcePointers, this::throwMemoryCreationException)
				: MEMORY_BUILDER.build(context, resourcePointers);
		if (debug) IVulkanDebugService.INSTANCE.register(memory.ptr(), memoryChunk.getName());

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
		if (useTransfer) needTransfer = true;
		else allocationState.requestUpdate();
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
		final var transferBufferAllocation = transferBuffer.adaptNotNull(TransferBufferAllocation.class);
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
		final var message = String.format("Transfer of MemoryChunkParts [%s] failed (TransferBuffer full?)",
										  memoryChunk.getName());
		System.out.println(message);
	}

	@SuppressWarnings("unchecked")
	public <T extends StaticImage & ImageViewer> Memory.BoundResource<VkImage> getBoundResource(final T imageMemory)
	{
		return (Memory.BoundResource<VkImage>) getBoundResource((IMemoryChunkPart) imageMemory);
	}

	@SuppressWarnings("unchecked")
	public Memory.BoundResource<VkBuffer> getBoundResource(final BufferMemory bufferMemory)
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
		return memoryChunk.getParts().indexOf(memoryPart);
	}

	private void throwMemoryCreationException(final String reason)
	{
		throw new IllegalStateException("Error when allocating Memory [" + memoryChunk.getName() + "], reason: " + reason);
	}
}
