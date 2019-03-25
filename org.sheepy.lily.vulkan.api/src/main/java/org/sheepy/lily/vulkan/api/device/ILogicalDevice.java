package org.sheepy.lily.vulkan.api.device;

import java.nio.IntBuffer;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;

public interface ILogicalDevice
{
	VkDevice getVkDevice();

	IPhysicalDevice getPhysicalDevice();

	VkPhysicalDevice getVkPhysicalDevice();

	VulkanQueue createPresentQueue(VkSurface surface);

	boolean isQueueExclusive();

	IntBuffer allocQueueIndices();
}
