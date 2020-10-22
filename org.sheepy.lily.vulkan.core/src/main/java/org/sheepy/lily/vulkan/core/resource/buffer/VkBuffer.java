package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.debug.VulkanDebugService;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;

import static org.lwjgl.vulkan.VK10.vkDestroyBuffer;

public record VkBuffer(long ptr) implements IVulkanResourcePointer
{
	@Override
	public void free(final VkDevice vkDevice)
	{
		if (DebugUtil.DEBUG_ENABLED) VulkanDebugService.INSTANCE.remove(ptr);
		vkDestroyBuffer(vkDevice, ptr, null);
	}
}
