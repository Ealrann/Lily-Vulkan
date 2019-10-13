package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.queue.VulkanQueue;

public interface IProcessAdapter extends IVulkanAdapter
{
	void start(IVulkanContext context);
	void stop(IVulkanContext context);

	void run();

	VulkanQueue getQueue();
	EQueueType getQueueType();

	static IProcessAdapter adapt(IProcess process)
	{
		return IAdapterFactoryService.INSTANCE.adapt(process, IProcessAdapter.class);
	}
}
