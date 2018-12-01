package org.sheepy.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputerBufferBarrier;
import org.sheepy.vulkan.process.compute.execution.ComputeCommandBuffer;
import org.sheepy.vulkan.resource.buffer.BufferAdapter;

public class ComputeBufferBarrierAdapter extends AbstractDeepAllocableAdapter implements IComputerAdapter
{
	private VkBufferMemoryBarrier.Buffer barrierInfo;

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		var barrier = ((ComputerBufferBarrier) target).getBufferBarrier();
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
	public void record(ComputeCommandBuffer commandBuffer, int bindPoint)
	{
		var barrier = ((ComputerBufferBarrier) target).getBufferBarrier();

		vkCmdPipelineBarrier(commandBuffer.getVkCommandBuffer(), barrier.getSrcStage().getValue(),
				barrier.getDstStage().getValue(), 0, null, barrierInfo, null);
	}
	
	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ComputePackage.Literals.COMPUTER_BUFFER_BARRIER == eClass;
	}

}
