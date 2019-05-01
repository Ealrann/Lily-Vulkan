package org.sheepy.lily.vulkan.resource.barrier;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.barrier.IBarrierExecutor;

public class BufferBarrierExecutor implements IBarrierExecutor
{
	private final BufferBarrier barrier;

	private VkBufferMemoryBarrier.Buffer barrierInfos = null;
	private EPipelineStage srcStage;
	private EPipelineStage dstStage;

	BufferBarrierExecutor(BufferBarrier barrier)
	{
		this.barrier = barrier;
	}

	@Override
	public void allocate()
	{
		allocate(VK_QUEUE_FAMILY_IGNORED, VK_QUEUE_FAMILY_IGNORED);
	}

	@Override
	public void allocate(int srcQueueFamillyIndex, int dstQueueFamillyIndex)
	{
		var buffer = barrier.getBuffer();
		var bufferAdapter = BufferAdapter.adapt(buffer);

		barrierInfos = VkBufferMemoryBarrier.calloc(1);
		srcStage = barrier.getSrcStage();
		dstStage = barrier.getDstStage();

		VkBufferMemoryBarrier barrierInfo = barrierInfos.get();
		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(bufferAdapter.getAddress());
		barrierInfo.srcAccessMask(barrier.getSrcAccess().getValue());
		barrierInfo.dstAccessMask(barrier.getDstAccess().getValue());
		barrierInfo.offset(0);
		barrierInfo.size(VK_WHOLE_SIZE);
		barrierInfo.srcQueueFamilyIndex(srcQueueFamillyIndex);
		barrierInfo.dstQueueFamilyIndex(dstQueueFamillyIndex);

		barrierInfos.flip();
	}

	@Override
	public void free()
	{
		barrierInfos.free();
		barrierInfos = null;
	}

	@Override
	public void execute(VkCommandBuffer commandBuffer)
	{
		vkCmdPipelineBarrier(commandBuffer, srcStage.getValue(), dstStage.getValue(), 0, null,
				barrierInfos, null);
	}
}
