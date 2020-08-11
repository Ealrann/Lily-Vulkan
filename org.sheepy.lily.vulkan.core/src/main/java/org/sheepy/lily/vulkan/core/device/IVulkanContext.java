package org.sheepy.lily.vulkan.core.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.core.instance.VulkanInstance;
import org.sheepy.lily.vulkan.core.window.Window;

public interface IVulkanContext extends IVulkanApiContext
{
	@Override
	Window getWindow();

	@Override
	PhysicalDevice getPhysicalDevice();

	VkPhysicalDevice getVkPhysicalDevice();

	@Override
	LogicalDevice getLogicalDevice();

	VkDevice getVkDevice();
	VkInstance getVkInstance();
}
