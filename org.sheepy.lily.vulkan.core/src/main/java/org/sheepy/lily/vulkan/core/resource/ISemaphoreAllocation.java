package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

public interface ISemaphoreAllocation extends IAllocation
{
	VkSemaphore getVkSemaphore();
}
