package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBufferAllocator;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.AlignmentUtil;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAdapter;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ModelExtender(scope = BufferMemory.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.BUFFER_MEMORY__BUFFERS)
public final class BufferMemoryAllocation extends Notifier<IMemoryChunkPartAllocation.Features> implements
																								IMemoryChunkPartAllocation
{
	private final BufferMemory bufferMemory;
	private final ExecutionContext context;
	private final GPUBufferBackend bufferBackend;
	private final ChunkInfo chunkInfo;

	public BufferMemoryAllocation(BufferMemory bufferMemory,
								  IAllocationState allocationState,
								  ExecutionContext context,
								  IObservatoryBuilder observatory)
	{
		super(Features.Values);

		this.bufferMemory = bufferMemory;
		this.context = context;

		chunkInfo = new ChunkInfo(buildAlignmentData(context.getPhysicalDevice(), bufferMemory));
		bufferBackend = createBufferBackend(chunkInfo.size, chunkInfo.usage);

		observatory.explore(VulkanResourcePackage.MEMORY_CHUNK__PARTS)
				   .adaptNotifier(IBufferAdapter.class)
				   .listenNoParam(() -> {
					   allocationState.setAllocationObsolete();
					   notify(Features.Obsolete);
				   }, IBufferAdapter.Features.Size);
	}

	private GPUBufferBackend createBufferBackend(long size, int usage)
	{
		final var info = new BufferInfo(size, usage, false, true);
		info.computeAlignment(context.getPhysicalDevice());
		final long ptr = VkBufferAllocator.allocate(context, info);
		return new GPUBufferBackend(info.getAlignedSize(), ptr);
	}

	@Override
	public void registerMemory(MemoryBuilder memoryBuilder)
	{
		memoryBuilder.registerBuffer(bufferBackend.getAddress(), bufferBackend::bindBufferMemory);
	}

	@Free
	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
	}

	public void attach(final IRecordContext recordContext)
	{
		notify(Features.Attach, recordContext);
	}

	public AlignmentData getAlignmentData(IBuffer buffer)
	{
		return chunkInfo.data.get(bufferMemory.getBuffers().indexOf(buffer));
	}

	@Override
	public Stream<FillCommand> streamFillCommands(boolean force)
	{
		final var buffers = bufferMemory.getBuffers();
		final long bufferPtr = bufferBackend.getAddress();

		return IntStream.range(0, buffers.size())
						.mapToObj(this::newBufferData)
						.filter(data -> force || data.bufferAllocation.needPush())
						.map(data -> data.buildFillCommand(bufferPtr));
	}

	private BufferData newBufferData(int index)
	{
		final var bufferAllocation = bufferMemory.getBuffers().get(index).adapt(IBufferAllocation.class);
		final var alignmentData = chunkInfo.data.get(index);
		return new BufferData(bufferAllocation, alignmentData);
	}

	private static record BufferData(IBufferAllocation bufferAllocation, AlignmentData alignmentData)
	{
		public FillCommand buildFillCommand(long bufferPtr)
		{
			return new FillCommand.FillBufferCommand(bufferAllocation::fillData,
													 bufferPtr,
													 alignmentData.offset(),
													 alignmentData.size());
		}
	}

	public long getBufferPtr()
	{
		return bufferBackend.getAddress();
	}

	private static List<AlignmentData> buildAlignmentData(final PhysicalDevice physicalDevice,
														  final BufferMemory bufferMemory)
	{
		long position = 0;
		final List<AlignmentData> tmpData = new ArrayList<>();
		for (final var buffer : bufferMemory.getBuffers())
		{
			final var sizeAdapter = buffer.adaptNotNull(IBufferAdapter.class);
			final long size = sizeAdapter.getSize(buffer);
			final int usage = VulkanModelUtil.getEnumeratedFlag(buffer.getUsages());

			final long alignment = physicalDevice.getBufferAlignement(usage, true);
			position = AlignmentUtil.align(position, alignment);
			final long alignedSize = AlignmentUtil.align(size, alignment);

			tmpData.add(new AlignmentData(position, alignedSize, usage));
			position += alignedSize;
		}
		return List.copyOf(tmpData);
	}

	public void requestPush()
	{
		notify(Features.PushRequest);
	}

	public static record ChunkInfo(List<AlignmentData> data, long size, int usage)
	{
		private ChunkInfo(List<AlignmentData> data)
		{
			this(data, totalSize(data), cumulateUsages(data));
		}

		private static long totalSize(final List<AlignmentData> data)
		{
			return data.stream().mapToLong(AlignmentData::size).sum();
		}

		private static int cumulateUsages(final List<AlignmentData> data)
		{
			return data.stream().mapToInt(AlignmentData::usage).reduce((a, b) -> a | b).orElse(0);
		}
	}
}
