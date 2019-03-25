package org.sheepy.lily.vulkan.api.process;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.device.ILogicalDevice;
import org.sheepy.lily.vulkan.api.device.IPhysicalDevice;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;

public interface IVulkanContext extends IAllocationContext
{
	IPhysicalDevice getPhysicalDevice();

	VkPhysicalDevice getVkPhysicalDevice();

	ILogicalDevice getLogicalDevice();

	Window getWindow();

	VkDevice getVkDevice();
}
