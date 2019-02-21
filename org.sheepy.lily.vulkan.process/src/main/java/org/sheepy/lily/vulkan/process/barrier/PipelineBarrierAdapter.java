package org.sheepy.lily.vulkan.process.barrier;

import static org.lwjgl.vulkan.VK10.VK_QUEUE_FAMILY_IGNORED;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineUnitAdapter;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.resource.barrier.BarrierExecutorFactory;
import org.sheepy.lily.vulkan.resource.barrier.IBarrierExecutor;

public class PipelineBarrierAdapter extends AbstractDeepAllocableAdapter
		implements IPipelineUnitAdapter<AbstractCommandBuffer>
{
	private IBarrierExecutor executor;

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		var pipelineBarrier = (PipelineBarrier) target;
		var barrier = pipelineBarrier.getBarrier();

		executor = BarrierExecutorFactory.create(barrier);

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
	public void free()
	{
		executor.free();
	}

	@Override
	public void record(AbstractCommandBuffer commandBuffer, int bindPoint)
	{
		executor.execute(commandBuffer.getVkCommandBuffer());
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ProcessPackage.Literals.PIPELINE_BARRIER == eClass;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
