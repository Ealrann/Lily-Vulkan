package org.sheepy.vulkan.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;

public interface ILogicalDeviceContext
{
	PhysicalDevice getPhysicalDevice();

	VkPhysicalDevice getVkPhysicalDevice();

	LogicalDevice getLogicalDevice();

	VkDevice getVkDevice();
}
