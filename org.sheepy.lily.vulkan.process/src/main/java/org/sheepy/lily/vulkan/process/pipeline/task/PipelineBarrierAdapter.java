package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.process.pipeline.task.internal.BufferBarriersBackend;
import org.sheepy.lily.vulkan.process.pipeline.task.internal.ImageBarriersBackend;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;

@Statefull
@Adapter(scope = PipelineBarrier.class)
public class PipelineBarrierAdapter
		implements IPipelineTaskAdapter<PipelineBarrier>, IAllocableAdapter<IProcessContext>
{
	private final PipelineBarrier pipelineBarrier;
	private final int srcStage;
	private final int dstStage;

	private ImageBarriersBackend imageBarrierInfos;
	private BufferBarriersBackend bufferBarrierInfos;

	public PipelineBarrierAdapter(PipelineBarrier pipelineBarrier)
	{
		this.pipelineBarrier = pipelineBarrier;

		srcStage = pipelineBarrier.getSrcStage().getValue();
		dstStage = pipelineBarrier.getDstStage().getValue();
	}

	@Override
	public void allocate(MemoryStack stack, IProcessContext context)
	{
		final int swapCount = context.getSwapCount();
		final var logicalDevice = context.getLogicalDevice();
		final var srcQueue = pipelineBarrier.getSrcQueue();
		final var dstQueue = pipelineBarrier.getDstQueue();

		final int srcQueueIndex = getQueueFamillyIndex(logicalDevice, srcQueue);
		final int dstQueueIndex = getQueueFamillyIndex(logicalDevice, dstQueue);

		final var barriers = pipelineBarrier.getBarriers();

		final List<AbstractImageBarrier> imageBarriers = new ArrayList<>();
		final List<AbstractBufferBarrier> bufferBarriers = new ArrayList<>();

		for (final var barrier : barriers)
		{
			if (barrier instanceof AbstractImageBarrier)
			{
				imageBarriers.add((AbstractImageBarrier) barrier);
			}
			else if (barrier instanceof AbstractBufferBarrier)
			{
				bufferBarriers.add((AbstractBufferBarrier) barrier);
			}
		}

		imageBarrierInfos = new ImageBarriersBackend(swapCount, srcQueueIndex, dstQueueIndex,
				imageBarriers);
		bufferBarrierInfos = new BufferBarriersBackend(swapCount, srcQueueIndex, dstQueueIndex,
				bufferBarriers);

		imageBarrierInfos.allocate(stack, context);
		bufferBarrierInfos.allocate(stack, context);
	}

	@Override
	public void free(IProcessContext context)
	{
		imageBarrierInfos.free(context);
		bufferBarrierInfos.free(context);
	}

	@Override
	public void record(PipelineBarrier barrier, RecordContext context)
	{
		final var bufferInfo = bufferBarrierInfos.get(context.index);
		final var imageInfo = imageBarrierInfos.get(context.index);

		vkCmdPipelineBarrier(context.commandBuffer, srcStage, dstStage, 0, null, bufferInfo,
				imageInfo);
	}

	private static int getQueueFamillyIndex(LogicalDevice logicalDevice, AbstractProcess process)
	{
		int res = VK_QUEUE_FAMILY_IGNORED;
		if (process != null)
		{
			final var queueType = IProcessAdapter.adapt(process).getQueueType();
			res = logicalDevice.getQueueIndex(queueType);
		}
		return res;
	}

	@Override
	public boolean isAllocationDirty(IProcessContext context)
	{
		return imageBarrierInfos.isAllocationDirty(context)
				|| bufferBarrierInfos.isAllocationDirty(context);
	}
}