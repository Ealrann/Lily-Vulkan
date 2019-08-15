package org.sheepy.vulkan.execution;

import java.util.Collection;

import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.queue.VulkanQueue;

public interface IExecutionContext extends IVulkanContext
{
	VulkanQueue getQueue();
	CommandPool getCommandPool();

	void execute(ISingleTimeCommand command);
	void execute(Collection<VkSemaphore> semaphoreToSignal, ISingleTimeCommand command);
}
