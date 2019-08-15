package org.sheepy.vulkan.device;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.vulkan.window.Window;

public interface IVulkanContext extends IAllocationContext
{
	MemoryStack stackPush();
	void stackPop();
	MemoryStack stack();

	Window getWindow();

	PhysicalDevice getPhysicalDevice();
	VkPhysicalDevice getVkPhysicalDevice();
	LogicalDevice getLogicalDevice();
	VkDevice getVkDevice();
}
