package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.barrier.IBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkBarrier;
import org.sheepy.lily.vulkan.core.barrier.VkBufferBarrier;
import org.sheepy.lily.vulkan.core.barrier.VkBufferBarriers;
import org.sheepy.lily.vulkan.core.barrier.VkImageBarriers;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
@Adapter(scope = PipelineBarrier.class)
public class PipelineBarrierAdapter
		implements IPipelineTaskAdapter<PipelineBarrier>, IAllocableAdapter<ProcessContext<?>>
{
	private final PipelineBarrier pipelineBarrier;
	private final int srcStage;
	private final int dstStage;

	private VkImageBarriers imageBarrierInfos;
	private VkBufferBarriers bufferBarrierInfos;

	public PipelineBarrierAdapter(PipelineBarrier pipelineBarrier)
	{
		this.pipelineBarrier = pipelineBarrier;

		srcStage = pipelineBarrier.getSrcStage().getValue();
		dstStage = pipelineBarrier.getDstStage().getValue();
	}

	@Override
	public void configureAllocation(IAllocationConfigurator configurator, ProcessContext<?> context)
	{
		final List<IAllocableAdapter<?>> allocables = new ArrayList<>();
		final var barriers = pipelineBarrier.getBarriers();
		for (final var barrier : barriers)
		{
			final var adapter = barrier.adapt(IAllocableAdapter.class);
			if (adapter != null)
			{
				allocables.add(adapter);
			}
		}

		configurator.addChildren(allocables);
	}

	@Override
	public void allocate(ProcessContext<?> context)
	{
		final var logicalDevice = context.getLogicalDevice();
		final var srcQueue = pipelineBarrier.getSrcQueue();
		final var dstQueue = pipelineBarrier.getDstQueue();

		final int srcQueueIndex = getQueueFamillyIndex(logicalDevice, srcQueue);
		final int dstQueueIndex = getQueueFamillyIndex(logicalDevice, dstQueue);

		final var barriers = pipelineBarrier.getBarriers();

		final List<VkBarrier<VkImageMemoryBarrier>> imageBarriers = new ArrayList<>();
		final List<VkBufferBarrier> bufferBarriers = new ArrayList<>();

		for (final var barrier : barriers)
		{
			if (barrier instanceof AbstractImageBarrier)
			{
				final var adapter = barrier.adaptNotNull(IImageBarrierAdapter.class);
				imageBarriers.add(adapter.getBackend());
			}
			else if (barrier instanceof AbstractBufferBarrier)
			{
				final var adapter = barrier.adaptNotNull(BufferBarrierAdapter.class);
				bufferBarriers.add(adapter.getBackend());
			}
		}

		imageBarrierInfos = new VkImageBarriers(srcQueueIndex, dstQueueIndex, imageBarriers);
		bufferBarrierInfos = new VkBufferBarriers(srcQueueIndex, dstQueueIndex, bufferBarriers);
	}

	@Override
	public ECommandStage getStage(PipelineBarrier task)
	{
		return task.getRecordDuringStage();
	}

	@Override
	public void free(ProcessContext<?> context)
	{
		imageBarrierInfos = null;
		bufferBarrierInfos = null;
	}

	@Override
	public void update(PipelineBarrier task, int index)
	{
		for (final var barrier : task.getBarriers())
		{
			final var barrierAdapter = barrier.adaptNotNull(IBarrierAdapter.class);
			barrierAdapter.update(index);
		}
	}

	@Override
	public void record(PipelineBarrier barrier, IRecordContext context)
	{
		final var bufferInfo = bufferBarrierInfos.allocateInfo(context.stack());
		final var imageInfo = imageBarrierInfos.allocateInfo(context.stack());

		vkCmdPipelineBarrier(	((RecordContext) context).commandBuffer,
								srcStage,
								dstStage,
								0,
								null,
								bufferInfo,
								imageInfo);
	}

	@Override
	public boolean needRecord(PipelineBarrier task, int index)
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
