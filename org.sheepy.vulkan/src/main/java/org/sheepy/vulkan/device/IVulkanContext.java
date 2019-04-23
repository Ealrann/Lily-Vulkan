package org.sheepy.vulkan.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.window.Window;

public interface IVulkanContext extends IAllocationContext
{

	void setLogicalDevice(LogicalDevice logicalDevice);

	void setWindow(Window window);

	Window getWindow();

	PhysicalDevice getPhysicalDevice();

	VkPhysicalDevice getVkPhysicalDevice();

	LogicalDevice getLogicalDevice();

	VkDevice getVkDevice();

}