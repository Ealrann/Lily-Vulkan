package org.sheepy.lily.vulkan.process.barrier;

import static org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineUnitAdapter;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.resource.barrier.BarrierExecutorFactory;
import org.sheepy.lily.vulkan.resource.barrier.IBarrierExecutor;

@Statefull
@Adapter(scope = PipelineBarrier.class)
public class PipelineBarrierAdapter
		implements IPipelineUnitAdapter<AbstractCommandBuffer>, IAllocableAdapter
{
	private final PipelineBarrier pipelineBarrier;
	private final IBarrierExecutor executor;

	public PipelineBarrierAdapter(PipelineBarrier pipelineBarrier)
	{
		this.pipelineBarrier = pipelineBarrier;
		var barrier = pipelineBarrier.getBarrier();

		executor = BarrierExecutorFactory.create(barrier);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		int srcQueueIndex = getQueueFamillyIndex(pipelineBarrier.getSrcQueue());
		int dstQueueIndex = getQueueFamillyIndex(pipelineBarrier.getDstQueue());

		executor.allocate(srcQueueIndex, dstQueueIndex);
	}

	private static int getQueueFamillyIndex(AbstractProcess process)
	{
		int res = VK_QUEUE_FAMILY_IGNORED;
		if (process != null)
		{
			var queue = AbstractProcessAdapter.adapt(process).getQueue();
			res = queue.index;
		}
		return res;
	}

	@Override
	public void free(IAllocationContext context)
	{
		executor.free();
	}

	@Override
	public void record(IPipelineUnit unit, AbstractCommandBuffer commandBuffer, int bindPoint)
	{
		executor.execute(commandBuffer.getVkCommandBuffer());
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
