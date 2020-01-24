package org.sheepy.lily.vulkan.common.device;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.device.IVulkanContext;
import org.sheepy.lily.vulkan.common.window.Window;

public interface InternalVulkanContext extends IVulkanContext
{
	@Override
	Window getWindow();
	@Override
	PhysicalDevice getPhysicalDevice();
	@Override
	LogicalDevice getLogicalDevice();

	MemoryStack stackPush();
	void stackPop();

	VkDevice getVkDevice();
	VkPhysicalDevice getVkPhysicalDevice();
}
