package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferCreateInfo;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.util.Logger;

import static org.lwjgl.vulkan.VK10.*;

public final class VkBufferAllocator
{
	public static VkBuffer allocate(final IVulkanContext context, final BufferInfo bufferInfo, final String name)
	{
		if (bufferInfo.getAlignedSize() == 0)
		{
			new IllegalStateException(name + " (BufferMemory) size == 0").printStackTrace();
		}

		final var stack = context.stack();
		final var device = context.getVkDevice();
		final var bufferCreateInfo = allocateInfo(stack, bufferInfo);
		final long[] aVertexBuffer = new long[1];

		final var res = vkCreateBuffer(device, bufferCreateInfo, null, aVertexBuffer);
		Logger.check(res, "Failed to create vertex buffer " + name);

		final long ptr = aVertexBuffer[0];
		if (DebugUtil.DEBUG_ENABLED)
		{
			IVulkanDebugService.INSTANCE.register(ptr, name);
		}
		return new VkBuffer(ptr);
	}

	private static VkBufferCreateInfo allocateInfo(MemoryStack stack, BufferInfo bufferInfo)
	{
		return VkBufferCreateInfo.callocStack(stack)
								 .set(VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO,
									  VK_NULL_HANDLE,
									  0,
									  bufferInfo.getAlignedSize(),
									  bufferInfo.usage,
									  VK_SHARING_MODE_EXCLUSIVE,
									  null);
	}
}
