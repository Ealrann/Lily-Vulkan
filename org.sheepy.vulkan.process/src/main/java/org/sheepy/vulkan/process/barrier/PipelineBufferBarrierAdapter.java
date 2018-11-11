package org.sheepy.vulkan.process.barrier;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.PipelineBufferBarrier;
import org.sheepy.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.process.pipeline.PipelineBarrierAdapter;
import org.sheepy.vulkan.resource.buffer.BufferAdapter;

public class PipelineBufferBarrierAdapter extends PipelineBarrierAdapter
{
	private VkBufferMemoryBarrier.Buffer barrierInfo;

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		var barrier = ((PipelineBufferBarrier) target).getBufferBarrier();
		var buffer = barrier.getBuffer();
		var bufferAdapter = BufferAdapter.adapt(buffer);

		barrierInfo = VkBufferMemoryBarrier.calloc(1);
		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(bufferAdapter.getId());
		barrierInfo.srcAccessMask(barrier.getSrcAccess());
		barrierInfo.dstAccessMask(barrier.getDstAccess());
		barrierInfo.offset(0);
		barrierInfo.size(VK_WHOLE_SIZE);
	}

	@Override
	public void free()
	{
		barrierInfo.free();
	}

	@Override
	public void record(AbstractCommandBuffer commandBuffer, int bindPoint)
	{
		var barrier = ((PipelineBufferBarrier) target).getBufferBarrier();

		vkCmdPipelineBarrier(commandBuffer.getVkCommandBuffer(), barrier.getSrcStage().getValue(),
				barrier.getDstStage().getValue(), 0, null, barrierInfo, null);
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ProcessPackage.Literals.PIPELINE_BUFFER_BARRIER == eClass;
	}
}
