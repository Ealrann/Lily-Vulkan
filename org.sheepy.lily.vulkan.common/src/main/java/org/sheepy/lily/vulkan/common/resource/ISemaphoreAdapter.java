package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;

public interface ISemaphoreAdapter extends IVulkanResourceAdapter
{
	VkSemaphore getVkSemaphore();
}
