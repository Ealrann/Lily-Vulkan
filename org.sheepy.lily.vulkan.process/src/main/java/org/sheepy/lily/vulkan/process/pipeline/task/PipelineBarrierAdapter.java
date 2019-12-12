package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.common.process.IExecutionProcessAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.process.pipeline.task.internal.BufferBarriersBackend;
import org.sheepy.lily.vulkan.process.pipeline.task.internal.ImageBarriersBackend;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

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
	private IAllocationConfigurator allocationConfiguration;

	public PipelineBarrierAdapter(PipelineBarrier pipelineBarrier)
	{
		this.pipelineBarrier = pipelineBarrier;

		srcStage = pipelineBarrier.getSrcStage().getValue();
		dstStage = pipelineBarrier.getDstStage().getValue();
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IProcessContext context)
	{
		this.allocationConfiguration = config;
	}

	@Override
	public void allocate(IProcessContext context)
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

		imageBarrierInfos = new ImageBarriersBackend(	swapCount,
														srcQueueIndex,
														dstQueueIndex,
														imageBarriers);
		bufferBarrierInfos = new BufferBarriersBackend(	swapCount,
														srcQueueIndex,
														dstQueueIndex,
														bufferBarriers);

		allocationConfiguration.addChildren(List.of(imageBarrierInfos, bufferBarrierInfos));
		allocationConfiguration.addDependencies(List.of(imageBarrierInfos, bufferBarrierInfos));
	}

	@Override
	public ECommandStage getStage(PipelineBarrier task)
	{
		return task.getRecordDuringStage();
	}

	@Override
	public void free(IProcessContext context)
	{
		allocationConfiguration.removeDependencies(List.of(imageBarrierInfos, bufferBarrierInfos));
		allocationConfiguration.removeChildren(List.of(imageBarrierInfos, bufferBarrierInfos));

		imageBarrierInfos = null;
		bufferBarrierInfos = null;
	}

	@Override
	public void record(PipelineBarrier barrier, RecordContext context)
	{
		final var bufferInfo = bufferBarrierInfos.get(context.index);
		final var imageInfo = imageBarrierInfos.get(context.index);

		vkCmdPipelineBarrier(	context.commandBuffer,
								srcStage,
								dstStage,
								0,
								null,
								bufferInfo,
								imageInfo);
	}

	private static int getQueueFamillyIndex(LogicalDevice logicalDevice, AbstractProcess process)
	{
		int res = VK_QUEUE_FAMILY_IGNORED;
		if (process != null)
		{
			final var adapter = process.adaptNotNull(IExecutionProcessAdapter.class);
			final var queueType = adapter.getExecutionQueueType();
			res = logicalDevice.getQueueFamilyIndex(queueType);
		}
		return res;
	}
}
