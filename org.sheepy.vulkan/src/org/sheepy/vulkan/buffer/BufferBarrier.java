package org.sheepy.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.pipeline.PipelineBarrier;

public class BufferBarrier extends PipelineBarrier
{
	public final Buffer buffer;

	public final int srcStage;
	public final int dstStage;

	public final int srcAccessMask;
	public final int dstAccessMask;

	private VkBufferMemoryBarrier.Buffer barrierInfo;

	public BufferBarrier(Buffer buffer, int srcStage, int dstStage, int srcAccessMask,
			int dstAccessMask)
	{
		this.buffer = buffer;

		this.srcStage = srcStage;
		this.dstStage = dstStage;

		this.srcAccessMask = srcAccessMask;
		this.dstAccessMask = dstAccessMask;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		barrierInfo = VkBufferMemoryBarrier.calloc(1);
		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(buffer.getId());
		barrierInfo.srcAccessMask(srcAccessMask);
		barrierInfo.dstAccessMask(dstAccessMask);
		barrierInfo.offset(0);
		barrierInfo.size(VK_WHOLE_SIZE);
	}

	@Override
	public void execute(VkCommandBuffer commandBuffer)
	{
		vkCmdPipelineBarrier(commandBuffer, srcStage, dstStage, 0, null, barrierInfo, null);
	}

	@Override
	public void free()
	{
		barrierInfo.free();
	}
}
