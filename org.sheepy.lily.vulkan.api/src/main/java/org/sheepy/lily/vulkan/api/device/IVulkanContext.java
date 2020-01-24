package org.sheepy.lily.vulkan.api.device;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.window.IWindow;

public interface IVulkanContext extends IAllocationContext
{
	IWindow getWindow();
	IPhysicalDevice getPhysicalDevice();
	ILogicalDevice getLogicalDevice();

	MemoryStack stack();
}
