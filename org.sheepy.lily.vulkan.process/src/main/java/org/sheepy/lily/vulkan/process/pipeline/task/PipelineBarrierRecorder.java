package org.sheepy.lily.vulkan.process.pipeline.task;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.barrier.*;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED;
import static org.lwjgl.vulkan.VK10.vkCmdPipelineBarrier;

@ModelExtender(scope = PipelineBarrier.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ProcessPackage.PIPELINE_BARRIER__BARRIERS)
public final class PipelineBarrierRecorder implements IPipelineTaskRecorder
{
	private final PipelineBarrier pipelineBarrier;
	private final ProcessContext context;
	private final int srcStage;
	private final int dstStage;

	private List<IBarrierAdapter<?>> barrierAllocations;
	private VkImageBarriers imageBarrierInfos;
	private VkBufferBarriers bufferBarrierInfos;
	private boolean loaded = false;

	public PipelineBarrierRecorder(PipelineBarrier pipelineBarrier, ProcessContext context)
	{
		this.pipelineBarrier = pipelineBarrier;
		this.context = context;

		srcStage = pipelineBarrier.getSrcStage().getValue();
		dstStage = pipelineBarrier.getDstStage().getValue();
	}

	private void load()
	{
		final var logicalDevice = context.getLogicalDevice();
		final var srcQueue = pipelineBarrier.getSrcQueue();
		final var dstQueue = pipelineBarrier.getDstQueue();

		final int srcQueueIndex = getQueueFamillyIndex(logicalDevice, srcQueue);
		final int dstQueueIndex = getQueueFamillyIndex(logicalDevice, dstQueue);

		final List<VkBarrier<VkImageMemoryBarrier>> imageBarriers = new ArrayList<>();
		final List<VkBufferBarrier> bufferBarriers = new ArrayList<>();

		final var pipelineBarriers = pipelineBarrier.getBarriers();
		barrierAllocations = new ArrayList<>(pipelineBarriers.size());
		for (final var barrier : pipelineBarriers)
		{
			final var barrierAllocation = barrier.adapt(IBarrierAdapter.class);
			barrierAllocations.add(barrierAllocation);
		}

		for (final var barrier : this.barrierAllocations)
		{
			if (barrier instanceof IImageBarrierAdapter barrierAdapter)
			{
				imageBarriers.add(barrierAdapter.getBackend());
			}
			else if (barrier instanceof BufferBarrierAllocation barrierAdapter)
			{
				bufferBarriers.add(barrierAdapter.getBackend());
			}
		}

		imageBarrierInfos = new VkImageBarriers(srcQueueIndex, dstQueueIndex, imageBarriers);
		bufferBarrierInfos = new VkBufferBarriers(srcQueueIndex, dstQueueIndex, bufferBarriers);

		loaded = true;
	}

	@Override
	public ECommandStage getStage()
	{
		return pipelineBarrier.getRecordDuringStage();
	}

	@Override
	public void update(int index)
	{
		if (loaded == false)
		{
			load();
		}

		for (final var barrier : barrierAllocations)
		{
			barrier.update(index);
		}
	}

	@Override
	public void record(RecordContext context)
	{
		final var bufferInfo = bufferBarrierInfos.allocateInfo(context.stack());
		final var imageInfo = imageBarrierInfos.allocateInfo(context.stack());

		vkCmdPipelineBarrier(context.commandBuffer, srcStage, dstStage, 0, null, bufferInfo, imageInfo);
	}

	@Override
	public boolean isRecordDirty(int index)
	{
		return bufferBarrierInfos.hasChanged() || imageBarrierInfos.hasChanged();
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
