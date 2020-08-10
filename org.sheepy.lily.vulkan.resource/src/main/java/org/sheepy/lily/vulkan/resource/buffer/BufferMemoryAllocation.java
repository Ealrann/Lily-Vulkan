package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.IBufferBackend;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBufferAllocator;
import org.sheepy.lily.vulkan.core.util.AlignmentUtil;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.resource.BufferMemory;
import org.sheepy.lily.vulkan.model.resource.IBufferObject;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferObjectAdapter;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferObjectAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
		super(List.of(Features.PushRequest, Features.Attach));

		this.bufferMemory = bufferMemory;
		this.context = context;

		chunkInfo = new ChunkInfo(buildAlignmentData(context.getPhysicalDevice(), bufferMemory));
		bufferBackend = createBufferBackend(chunkInfo.size, chunkInfo.usage);

		observatory.explore(VulkanResourcePackage.MEMORY_CHUNK__PARTS)
				   .adaptNotifier(IBufferObjectAdapter.class)
				   .listenNoParam(allocationState::setAllocationObsolete, IBufferObjectAdapter.Features.Size);
	}

	@Free
	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
	}

	public AlignmentData getAlignmentData(IBufferObject buffer)
	{
		return chunkInfo.data.get(bufferMemory.getBuffers().indexOf(buffer));
	}

	@Override
	public PushData gatherPushData(boolean force, boolean computeSize)
	{
		final var buffers = bufferMemory.getBuffers();
		final long bufferPtr = bufferBackend.getAddress();

		final long size = computeSize ? buffers.stream()
											   .map(IBufferObjectAllocation::adapt)
											   .filter(bufferAllocation -> force || bufferAllocation.needPush())
											   .mapToLong(IBufferAllocation::getBindSize)
											   .sum() : 0;

		final var dataStream = IntStream.range(0, buffers.size())
									.mapToObj(this::newBufferData)
									.filter(data -> force || data.bufferAllocation.needPush())
									.map(data -> data.buildFillCommand(bufferPtr));

		return new PushData(dataStream, size);
	}

	private BufferData newBufferData(int index)
	{
		final var bufferAllocation = bufferMemory.getBuffers().get(index).adapt(IBufferObjectAllocation.class);
		final var alignmentData = chunkInfo.data.get(index);
		return new BufferData(bufferAllocation, alignmentData);
	}

	private static record BufferData(IBufferObjectAllocation bufferAllocation, AlignmentData alignmentData)
	{
		public FillCommand buildFillCommand(long bufferPtr)
		{
			return new FillCommand(bufferAllocation::fillData, bufferPtr, alignmentData.offset(), alignmentData.size());
		}
	}

	private GPUBufferBackend createBufferBackend(long size, int usage)
	{
		final var info = new BufferInfo(size, usage, false, true);
		info.computeAlignment(context.getPhysicalDevice());
		final long ptr = VkBufferAllocator.allocate(context, info);
		return new GPUBufferBackend(info, ptr, null);
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
			final var sizeAdapter = buffer.adaptNotNull(IBufferObjectAdapter.class);
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

	public void attach(final IRecordContext recordContext)
	{
		notify(Features.Attach, recordContext);
	}

	@Override
	public IBufferBackend getBackend()
	{
		return bufferBackend;
	}

	public static record ChunkInfo(List<AlignmentData>data, long size, int usage)
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
