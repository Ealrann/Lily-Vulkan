package org.sheepy.vulkan.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferCreateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.vulkan.model.Buffer;

public class VkBufferAllocator
{
	public static long allocate(MemoryStack stack, VkDevice device, Buffer buffer)
	{
		return create(stack, device, buffer);
	}

	private static long create(MemoryStack stack, VkDevice device, Buffer buffer)
			throws AssertionError
	{
		VkBufferCreateInfo bufferInfo = allocateInfo(stack, buffer);
		long[] aVertexBuffer = new long[1];
		if (vkCreateBuffer(device, bufferInfo, null, aVertexBuffer) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create vertex buffer!");
		}
		return aVertexBuffer[0];
	}

	private static VkBufferCreateInfo allocateInfo(MemoryStack stack, Buffer buffer)
	{
		VkBufferCreateInfo bufferInfo = VkBufferCreateInfo.callocStack(stack);
		bufferInfo.sType(VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO);
		bufferInfo.size(buffer.getSize());
		bufferInfo.usage(buffer.getUsage());
		bufferInfo.sharingMode(VK_SHARING_MODE_EXCLUSIVE);

		return bufferInfo;
	}
}
