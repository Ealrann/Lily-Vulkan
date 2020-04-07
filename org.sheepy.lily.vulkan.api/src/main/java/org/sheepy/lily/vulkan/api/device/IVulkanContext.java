package org.sheepy.lily.vulkan.api.device;

import org.sheepy.lily.game.api.allocation.IGameAllocationContext;
import org.sheepy.lily.game.api.window.IWindow;

public interface IVulkanContext extends IGameAllocationContext
{
	IWindow getWindow();
	IPhysicalDevice getPhysicalDevice();
	ILogicalDevice getLogicalDevice();
}
