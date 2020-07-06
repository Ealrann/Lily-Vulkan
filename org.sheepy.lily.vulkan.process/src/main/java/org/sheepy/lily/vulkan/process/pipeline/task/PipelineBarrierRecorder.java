package org.sheepy.lily.vulkan.process.pipeline.task;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.barrier.IBarrierAllocation;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAllocation;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.stream.Collectors;

import static org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED;
import static org.lwjgl.vulkan.VK10.vkCmdPipelineBarrier;

@ModelExtender(scope = PipelineBarrier.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(allocateBeforeParent = true, features = ProcessPackage.PIPELINE_BARRIER__BARRIERS)
@AllocationDependency(features = ProcessPackage.PIPELINE_BARRIER__BARRIERS, type = IBarrierAllocation.class)
public final class PipelineBarrierRecorder implements IRecordableExtender
{
	private final int srcStage;
	private final int dstStage;
	private final List<IImageBarrierAllocation> imageBarriers;
	private final List<BufferBarrierAllocation> bufferBarriers;
	private final int srcQueueIndex;
	private final int dstQueueIndex;
	private final int bufferBarrierSize;

	public PipelineBarrierRecorder(PipelineBarrier pipelineBarrier,
								   ProcessContext context,
								   @InjectDependency(index = 0) List<IBarrierAllocation<?>> barrierAllocations)
	{
		srcStage = pipelineBarrier.getSrcStage().getValue();
		dstStage = pipelineBarrier.getDstStage().getValue();

		final var logicalDevice = context.getLogicalDevice();
		final var srcQueue = pipelineBarrier.getSrcQueue();
		final var dstQueue = pipelineBarrier.getDstQueue();

		srcQueueIndex = getQueueFamillyIndex(logicalDevice, srcQueue);
		dstQueueIndex = getQueueFamillyIndex(logicalDevice, dstQueue);
		imageBarriers = filterBarriers(barrierAllocations, IImageBarrierAllocation.class);
		bufferBarriers = filterBarriers(barrierAllocations, BufferBarrierAllocation.class);
		bufferBarrierSize = bufferBarriers.stream().mapToInt(BufferBarrierAllocation::barrierCount).sum();
	}

	private static <T extends IBarrierAllocation<?>> List<T> filterBarriers(final List<IBarrierAllocation<?>> barrierAllocations,
																			final Class<T> barrierType)
	{
		return barrierAllocations.stream()
								 .filter(barrierType::isInstance)
								 .map(barrierType::cast)
								 .collect(Collectors.toUnmodifiableList());
	}

	@Override
	public void record(RecordContext context)
	{
		final var stack = context.stack();
		final int index = context.index;
		final int indexCount = context.indexCount;
		final var bufferInfo = allocateBufferInfo(stack, index, indexCount);
		final var imageInfo = allocateImageInfo(stack, index, indexCount);

		vkCmdPipelineBarrier(context.commandBuffer, srcStage, dstStage, 0, null, bufferInfo, imageInfo);
	}

	public VkBufferMemoryBarrier.Buffer allocateBufferInfo(MemoryStack stack, int index, int indexCount)
	{
		final var res = VkBufferMemoryBarrier.callocStack(bufferBarrierSize, stack);
		for (int i = 0; i < bufferBarrierSize; i++)
		{
			final var bufferBarrier = bufferBarriers.get(i);
			bufferBarrier.fill(res, index, indexCount, srcQueueIndex, dstQueueIndex);
		}
		res.flip();

		return res;
	}

	public VkImageMemoryBarrier.Buffer allocateImageInfo(MemoryStack stack, int index, int indexCount)
	{
		final int size = imageBarriers.size();
		final var res = VkImageMemoryBarrier.callocStack(size, stack);

		for (final var imageBarrier : imageBarriers)
		{
			final var info = res.get();
			imageBarrier.fill(info, index, indexCount, srcQueueIndex, dstQueueIndex);
		}
		res.flip();

		return res;
	}

	private static int getQueueFamillyIndex(LogicalDevice logicalDevice, AbstractProcess process)
	{
		int res = VK_QUEUE_FAMILY_IGNORED;
		if (process != null)
		{
			final var adapter = process.adaptNotNull(InternalProcessAdapter.class);
			final var queueType = adapter.getExecutionQueueType();
			res = logicalDevice.getQueueFamilyIndex(queueType);
		}
		return res;
	}
}
