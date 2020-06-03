package org.sheepy.lily.vulkan.process.pipeline.task;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
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
@AllocationDependency(features = ProcessPackage.PIPELINE_BARRIER__BARRIERS, type = IBarrierAdapter.class)
public final class PipelineBarrierRecorder implements IPipelineTaskRecorder
{
	private final PipelineBarrier pipelineBarrier;
	private final int srcStage;
	private final int dstStage;
	private final List<IBarrierAdapter<?>> barriers;
	private final VkImageBarriers imageBarrierInfos;
	private final VkBufferBarriers bufferBarrierInfos;

	public PipelineBarrierRecorder(PipelineBarrier pipelineBarrier,
								   ProcessContext context,
								   @InjectDependency(index = 0) List<IBarrierAdapter<?>> barriers)
	{
		this.pipelineBarrier = pipelineBarrier;
		this.barriers = barriers;

		srcStage = pipelineBarrier.getSrcStage().getValue();
		dstStage = pipelineBarrier.getDstStage().getValue();

		final var logicalDevice = context.getLogicalDevice();
		final var srcQueue = pipelineBarrier.getSrcQueue();
		final var dstQueue = pipelineBarrier.getDstQueue();

		final int srcQueueIndex = getQueueFamillyIndex(logicalDevice, srcQueue);
		final int dstQueueIndex = getQueueFamillyIndex(logicalDevice, dstQueue);

		final List<VkBarrier<VkImageMemoryBarrier>> imageBarriers = new ArrayList<>();
		final List<VkBufferBarrier> bufferBarriers = new ArrayList<>();

		for (final var barrier : barriers)
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
	}

	@Override
	public ECommandStage getStage()
	{
		return pipelineBarrier.getRecordDuringStage();
	}

	@Override
	public void update(int index)
	{
		for (final var barrier : barriers)
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
