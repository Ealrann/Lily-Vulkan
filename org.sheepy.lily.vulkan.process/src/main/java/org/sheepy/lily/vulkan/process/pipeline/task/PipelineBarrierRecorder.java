package org.sheepy.lily.vulkan.process.pipeline.task;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.barrier.IBarrierAllocation;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAllocation;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED;
import static org.lwjgl.vulkan.VK10.vkCmdPipelineBarrier;

@ModelExtender(scope = PipelineBarrier.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(allocateBeforeParent = true, features = PipelineBarrier.FeatureIDs.BARRIERS)
@AllocationDependency(features = PipelineBarrier.FeatureIDs.BARRIERS, type = IBarrierAllocation.class)
public final class PipelineBarrierRecorder implements IRecordableAdapter
{
	private final int srcStage;
	private final int dstStage;
	private final PipelineBarrier pipelineBarrier;
	private final List<IImageBarrierAllocation> imageBarriers;
	private final List<BufferBarrierAllocation> bufferBarriers;
	private final int srcQueueIndex;
	private final int dstQueueIndex;
	private final int bufferBarrierAllocSize;

	public PipelineBarrierRecorder(PipelineBarrier pipelineBarrier,
								   ProcessContext context,
								   IObservatoryBuilder observatory,
								   IAllocationState allocationState,
								   @InjectDependency(index = 0) List<IBarrierAllocation<?>> barrierAllocations)
	{
		this.pipelineBarrier = pipelineBarrier;
		srcStage = pipelineBarrier.srcStage().value();
		dstStage = pipelineBarrier.dstStage().value();

		final var logicalDevice = context.getLogicalDevice();
		final var srcQueue = pipelineBarrier.srcQueue();
		final var dstQueue = pipelineBarrier.dstQueue();

		srcQueueIndex = getQueueFamillyIndex(logicalDevice, srcQueue);
		dstQueueIndex = getQueueFamillyIndex(logicalDevice, dstQueue);
		imageBarriers = filterBarriers(barrierAllocations, IImageBarrierAllocation.class);
		bufferBarriers = filterBarriers(barrierAllocations, BufferBarrierAllocation.class);
		bufferBarrierAllocSize = bufferBarriers.stream().mapToInt(BufferBarrierAllocation::barrierCount).sum();

		observatory.listenNoParam(allocationState::setAllocationObsolete, PipelineBarrier.FeatureIDs.ENABLED);
	}

	private static <T extends IBarrierAllocation<?>> List<T> filterBarriers(final List<IBarrierAllocation<?>> barrierAllocations,
																			final Class<T> barrierType)
	{
		return barrierAllocations.stream().filter(barrierType::isInstance).map(barrierType::cast).toList();
	}

	@Override
	public void record(RecordContext context)
	{
		if (pipelineBarrier.enabled())
		{
			try (final var stack = MemoryStack.stackPush())
			{
				final var bufferInfo = allocateBufferInfo(stack, context);
				final var imageInfo = allocateImageInfo(stack, context);

				vkCmdPipelineBarrier(context.commandBuffer, srcStage, dstStage, 0, null, bufferInfo, imageInfo);
			}
		}
	}

	public VkBufferMemoryBarrier.Buffer allocateBufferInfo(MemoryStack stack, RecordContext context)
	{
		final var res = VkBufferMemoryBarrier.calloc(bufferBarrierAllocSize, stack);
		for (int i = 0; i < bufferBarriers.size(); i++)
		{
			final var bufferBarrier = bufferBarriers.get(i);
			bufferBarrier.fill(res, context, srcQueueIndex, dstQueueIndex);
		}
		res.flip();

		return res;
	}

	public VkImageMemoryBarrier.Buffer allocateImageInfo(MemoryStack stack, RecordContext recordContext)
	{
		final int size = imageBarriers.size();
		final var res = VkImageMemoryBarrier.calloc(size, stack);

		for (final var imageBarrier : imageBarriers)
		{
			final var info = res.get();
			imageBarrier.fill(info, recordContext, srcQueueIndex, dstQueueIndex);
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
