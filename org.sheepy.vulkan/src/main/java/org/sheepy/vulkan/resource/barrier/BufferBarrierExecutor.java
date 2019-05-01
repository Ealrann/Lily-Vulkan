package org.sheepy.vulkan.resource.barrier;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public abstract class BufferBarrierExecutor implements IBarrierExecutor
{
	private final AbstractBufferBarrier barrier;

	private VkBufferMemoryBarrier.Buffer barrierInfos = null;
	private EPipelineStage srcStage;
	private EPipelineStage dstStage;

	BufferBarrierExecutor(AbstractBufferBarrier barrier)
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
		final long bufferAddress = getBufferAddress();

		barrierInfos = VkBufferMemoryBarrier.calloc(1);
		srcStage = barrier.getSrcStage();
		dstStage = barrier.getDstStage();

		final var srcAccess = barrier.getSrcAccess();
		final var dstAccess = barrier.getDstAccess();
		final int srcAccessValue = srcAccess != null ? srcAccess.getValue() : 0;
		final int dstAccessValue = dstAccess != null ? dstAccess.getValue() : 0;

		final VkBufferMemoryBarrier barrierInfo = barrierInfos.get();
		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(bufferAddress);
		barrierInfo.srcAccessMask(srcAccessValue);
		barrierInfo.dstAccessMask(dstAccessValue);
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

	protected abstract long getBufferAddress();
}
