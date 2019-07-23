package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public interface ISemaphoreAdapter extends IResourceAdapter
{
	VkSemaphore getVkSemaphore();

	public static ISemaphoreAdapter adapt(Semaphore semaphore)
	{
		return IAdapterFactoryService.INSTANCE.adapt(semaphore, ISemaphoreAdapter.class);
	}
}
