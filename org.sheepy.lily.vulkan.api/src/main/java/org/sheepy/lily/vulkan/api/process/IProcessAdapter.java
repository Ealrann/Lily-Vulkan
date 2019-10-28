package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.queue.VulkanQueue;

public interface IProcessAdapter extends IVulkanAdapter
{
	void start(IVulkanContext context);
	void stop(IVulkanContext context);

	IFenceView run();

	VulkanQueue getQueue();
	EQueueType getQueueType();
}
