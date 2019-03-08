package org.sheepy.lily.vulkan.common.engine;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;

public interface IVulkanContext
{
	PhysicalDevice getPhysicalDevice();

	VkPhysicalDevice getVkPhysicalDevice();

	LogicalDevice getLogicalDevice();

	Window getWindow();

	VkDevice getVkDevice();
}
