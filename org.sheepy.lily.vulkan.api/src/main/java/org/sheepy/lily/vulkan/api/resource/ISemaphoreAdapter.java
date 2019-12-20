package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.vulkan.concurrent.VkSemaphore;

public interface ISemaphoreAdapter extends IVulkanResourceAdapter
{
	VkSemaphore getVkSemaphore();
}
