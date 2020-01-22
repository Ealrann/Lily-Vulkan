package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public interface ISemaphoreAdapter extends IVulkanResourceAdapter
{
	VkSemaphore getVkSemaphore();
}
