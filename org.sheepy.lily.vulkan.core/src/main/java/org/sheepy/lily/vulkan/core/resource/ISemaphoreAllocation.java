package org.sheepy.lily.vulkan.core.resource;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

public interface ISemaphoreAllocation extends IAdapter
{
	VkSemaphore getVkSemaphore();
}
