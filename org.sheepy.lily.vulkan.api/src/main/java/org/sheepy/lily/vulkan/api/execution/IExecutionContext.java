package org.sheepy.lily.vulkan.api.execution;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.api.process.IVulkanContext;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;

public interface IExecutionContext extends IVulkanContext
{
	VulkanQueue getQueue();

	void execute(ISingleTimeCommand command);

	void execute(MemoryStack stack, ISingleTimeCommand command);

	void execute(	MemoryStack stack,
					Collection<VkSemaphore> semaphoreToSignal,
					ISingleTimeCommand command);
}
