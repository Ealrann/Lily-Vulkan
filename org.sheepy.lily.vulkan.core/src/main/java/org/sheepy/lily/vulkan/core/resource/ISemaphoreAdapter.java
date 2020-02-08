package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

public interface ISemaphoreAdapter extends IVulkanResourceAdapter
{
	VkSemaphore getVkSemaphore();
}
