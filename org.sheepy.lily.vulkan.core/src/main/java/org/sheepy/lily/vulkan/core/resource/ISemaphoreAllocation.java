package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

public interface ISemaphoreAllocation extends IExtender
{
	VkSemaphore getVkSemaphore();
}
