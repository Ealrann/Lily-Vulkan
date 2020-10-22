package org.sheepy.lily.vulkan.core.resource;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.resource.buffer.VkBuffer;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;

public sealed interface IVulkanResourcePointer permits VkBuffer, VkImage
{
	long ptr();
	void free(VkDevice vkDevice);
}
