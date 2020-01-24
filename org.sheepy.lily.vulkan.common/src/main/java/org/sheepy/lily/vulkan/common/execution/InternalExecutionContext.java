package org.sheepy.lily.vulkan.common.execution;

import java.util.Collection;

import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.device.InternalVulkanContext;
import org.sheepy.lily.vulkan.common.device.VulkanContext;
import org.sheepy.lily.vulkan.common.execution.queue.VulkanQueue;

public interface InternalExecutionContext extends InternalVulkanContext, IExecutionContext
{
	VulkanQueue getQueue();
	CommandPool getCommandPool();

	void allocate(VulkanContext vulkanContext);
	void free();

	void execute(ISingleTimeCommand command);
	void execute(Collection<VkSemaphore> semaphoreToSignal, ISingleTimeCommand command);
}
