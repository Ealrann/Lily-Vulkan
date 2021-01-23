package org.sheepy.lily.vulkan.core.resource;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

public interface ISemaphoreAllocation extends IAdapter
{
	VkSemaphore getVkSemaphore();
}
