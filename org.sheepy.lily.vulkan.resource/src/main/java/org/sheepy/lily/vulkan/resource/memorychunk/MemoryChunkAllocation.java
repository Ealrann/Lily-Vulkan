package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.DeviceBufferFiller;
import org.sheepy.lily.vulkan.core.resource.buffer.GPUBufferBackend;
import org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = MemoryChunk.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.MEMORY_CHUNK__PARTS)
public class MemoryChunkAllocation implements IExtender
{
	private final MemoryChunk memoryChunk;
	private final IAllocationState allocationState;
	private final ExecutionContext context;
	private final GPUBufferBackend bufferBackend;
	private final MemoryInfo memoryInfo;
	private final DeviceBufferFiller partPusher;

	private final List<Integer> usedInRecords = new ArrayList<>();

	public MemoryChunkAllocation(MemoryChunk memoryChunk,
								 IAllocationState allocationState,
								 ExecutionContext context,
								 IObservatoryBuilder observatory)
	{
		this.memoryChunk = memoryChunk;
		this.allocationState = allocationState;
		this.context = context;

		memoryInfo = new MemoryInfo(buildAlignmentData(memoryChunk));
		bufferBackend = createBufferBackend(memoryInfo.size, memoryInfo.usage);
		partPusher = new DeviceBufferFiller(context, bufferBackend.getAddress());

		observatory.explore(VulkanResourcePackage.MEMORY_CHUNK__PARTS)
				   .adaptNotifier(IMemoryPartAdapter.class)
				   .listenNoParam(allocationState::setAllocationObsolete, IMemoryPartAdapter.Features.Size);
	}

	@Free
	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
	}

	public AlignmentData getAlignmentData(IMemoryChunkPart part)
	{
		return memoryInfo.data.get(memoryChunk.getParts().indexOf(part));
	}

	@InjectChildren(index = 0, type = IMemoryPartAllocation.class)
	private void updateChildren(List<IMemoryPartAllocation> partAllocations)
	{
		final List<DeviceBufferFiller.DataProvider> partsToPush = new ArrayList<>();
		gatherPartsToPush(partAllocations, partsToPush);

		if (partsToPush.isEmpty() == false)
		{
			partPusher.fillData(partsToPush);
		}
	}

	private void gatherPartsToPush(final List<IMemoryPartAllocation> partAllocations,
								   final List<DeviceBufferFiller.DataProvider> partsToPush)
	{
		for (int i = 0; i < partAllocations.size(); i++)
		{
			final var partAllocation = partAllocations.get(i);
			if (partAllocation.needPush())
			{
				final var alignmentData = memoryInfo.data.get(i);
				partsToPush.add(new DeviceBufferFiller.DataProvider(partAllocation::fillData,
																	alignmentData.offset(),
																	alignmentData.size()));
			}
		}
	}

	private GPUBufferBackend createBufferBackend(long size, int usage)
	{
		final var info = new BufferInfo(size, usage, false);
		final var bufferBuilder = new GPUBufferBackend.Builder(info, false);
		final var bufferBackend = bufferBuilder.build(context);
		return bufferBackend;
	}

	public long getBufferPtr()
	{
		return bufferBackend.getAddress();
	}

	private static List<AlignmentData> buildAlignmentData(final MemoryChunk memoryChunk)
	{
		int position = 0;
		final List<AlignmentData> tmpData = new ArrayList<>();
		for (final var part : memoryChunk.getParts())
		{
			final var sizeAdapter = part.adaptNotNull(IMemoryPartAdapter.class);

			final long size = sizeAdapter.getSize(part);
			tmpData.add(new AlignmentData(position, size, sizeAdapter.getUsage(part)));
			position += size;
		}
		return List.copyOf(tmpData);
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

	public static record MemoryInfo(List<AlignmentData>data, long size, int usage)
	{
		private MemoryInfo(List<AlignmentData> data)
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
