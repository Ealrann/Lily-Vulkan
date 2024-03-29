package org.sheepy.lily.vulkan.resource.buffer;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.DeviceLocalBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.HostVisibleBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.IBufferBackend;
import org.sheepy.lily.vulkan.core.resource.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAdapter;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.MemoryChunkAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ModelExtender(scope = BufferMemory.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.BUFFER_MEMORY__BUFFERS)
@AllocationDependency(parent = MemoryChunk.class, type = MemoryChunkAllocation.class)
public final class BufferMemoryAllocation implements IMemoryChunkPartAllocation
{
	private final BufferMemory bufferMemory;
	private final IBufferBackend bufferBackend;
	private final List<AlignmentData> alignmentDataList;
	private final MemoryChunkAllocation chunkAllocation;

	public BufferMemoryAllocation(final BufferMemory bufferMemory,
								  final IAllocationState allocationState,
								  final IObservatoryBuilder observatory,
								  final @InjectDependency(index = 0) MemoryChunkAllocation chunkAllocation)
	{
		this.bufferMemory = bufferMemory;
		this.alignmentDataList = bufferMemory.adapt(BufferMemoryAdapter.class).getChunkInfo().data();
		this.chunkAllocation = chunkAllocation;

		final var boundResource = chunkAllocation.getBoundResource(bufferMemory);
		final var memory = chunkAllocation.getMemory();
		bufferBackend = memory.info().hostVisible()
				? new HostVisibleBufferBackend(boundResource.vkResource(),
											   boundResource.size(),
											   memory,
											   false)
				: new DeviceLocalBufferBackend(boundResource.vkResource(), boundResource.size());

		observatory.explore(VulkanResourcePackage.MEMORY_CHUNK__PARTS)
				   .adaptNotifier(IBufferAdapter.class)
				   .listenNoParam(() -> {
					   allocationState.setAllocationObsolete();
					   chunkAllocation.markObsolete();
				   }, IBufferAdapter.Features.Size);
	}

	@Free
	private void free(final ExecutionContext context)
	{
		bufferBackend.free(context);
	}

	public void attach(final IRecordContext recordContext)
	{
		chunkAllocation.attach(recordContext);
	}

	public AlignmentData getAlignmentData(IBuffer buffer)
	{
		return alignmentDataList.get(bufferMemory.getBuffers().indexOf(buffer));
	}

	@Override
	public Stream<FillCommand> streamFillCommands(final boolean force)
	{
		final var buffers = bufferMemory.getBuffers();
		final var bufferPtr = bufferBackend.getAddress();
		final var regions = IntStream.range(0, buffers.size())
									 .mapToObj(this::newBufferAlignmentWrapper)
									 .filter(data -> force || data.bufferAllocation.needPush())
									 .map(BufferAlignmentWrapper::toRegion)
									 .toList();

		return Stream.of(new FillCommand.FillBufferCommand(bufferPtr, regions));
	}

	private BufferAlignmentWrapper newBufferAlignmentWrapper(final int index)
	{
		final var bufferAllocation = IBufferAllocation.adapt(bufferMemory.getBuffers().get(index));
		return new BufferAlignmentWrapper(bufferAllocation, alignmentDataList.get(index));
	}

	record BufferAlignmentWrapper(IBufferAllocation bufferAllocation, AlignmentData alignmentData)
	{
		public FillCommand.RegionFillInfo toRegion()
		{
			return new FillCommand.RegionFillInfo(bufferAllocation::fillData,
												  alignmentData.offset(),
												  alignmentData.size());
		}
	}

	public long getBufferPtr()
	{
		return bufferBackend.getAddress();
	}

	public void requestPush()
	{
		chunkAllocation.requestUpdate();
	}
}
