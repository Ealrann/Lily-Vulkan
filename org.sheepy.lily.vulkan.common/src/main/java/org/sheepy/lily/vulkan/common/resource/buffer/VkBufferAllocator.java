package org.sheepy.lily.vulkan.common.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferCreateInfo;
import org.sheepy.lily.vulkan.common.device.InternalVulkanContext;

public class VkBufferAllocator
{
	public static long allocate(InternalVulkanContext context, BufferInfo bufferInfo)
	{
		assert bufferInfo.getTotalSize() != 0;

		final var stack = context.stack();
		final var device = context.getVkDevice();
		final VkBufferCreateInfo bufferCreateInfo = allocateInfo(stack, bufferInfo);
		final long[] aVertexBuffer = new long[1];
		if (vkCreateBuffer(device, bufferCreateInfo, null, aVertexBuffer) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create vertex buffer");
		}
		return aVertexBuffer[0];
	}

	private static VkBufferCreateInfo allocateInfo(MemoryStack stack, BufferInfo bufferInfo)
	{
		final VkBufferCreateInfo bufferCreateInfo = VkBufferCreateInfo.callocStack(stack);
		bufferCreateInfo.sType(VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO);
		bufferCreateInfo.size(bufferInfo.getTotalSize());
		bufferCreateInfo.usage(bufferInfo.usage);
		bufferCreateInfo.sharingMode(VK_SHARING_MODE_EXCLUSIVE);

		return bufferCreateInfo;
	}
}
