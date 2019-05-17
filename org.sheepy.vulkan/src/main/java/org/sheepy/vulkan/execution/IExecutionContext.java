package org.sheepy.vulkan.execution;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.queue.VulkanQueue;

public interface IExecutionContext extends IVulkanContext
{
	VulkanQueue getQueue();
	CommandPool getCommandPool();

	void execute(ISingleTimeCommand command);

	void execute(MemoryStack stack, ISingleTimeCommand command);

	void execute(	MemoryStack stack,
					Collection<VkSemaphore> semaphoreToSignal,
					ISingleTimeCommand command);
}