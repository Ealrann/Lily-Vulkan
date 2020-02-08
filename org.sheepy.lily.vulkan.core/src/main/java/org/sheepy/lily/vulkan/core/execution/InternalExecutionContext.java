package org.sheepy.lily.vulkan.core.execution;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.device.InternalVulkanContext;
import org.sheepy.lily.vulkan.core.device.VulkanContext;
import org.sheepy.lily.vulkan.core.execution.queue.VulkanQueue;

import java.util.Collection;

public interface InternalExecutionContext extends InternalVulkanContext, IExecutionContext, IAllocable<VulkanContext>
{
	VulkanQueue getQueue();
	CommandPool getCommandPool();

	void execute(ISingleTimeCommand command);
	void execute(Collection<VkSemaphore> semaphoreToSignal, ISingleTimeCommand command);
}
