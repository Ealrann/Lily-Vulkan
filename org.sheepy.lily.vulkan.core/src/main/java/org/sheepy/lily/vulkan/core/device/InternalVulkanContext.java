package org.sheepy.lily.vulkan.core.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.window.Window;

public interface InternalVulkanContext extends IVulkanContext
{
	@Override
	Window getWindow();
	@Override
	PhysicalDevice getPhysicalDevice();
	@Override
	LogicalDevice getLogicalDevice();

	VkDevice getVkDevice();
	VkPhysicalDevice getVkPhysicalDevice();
}
