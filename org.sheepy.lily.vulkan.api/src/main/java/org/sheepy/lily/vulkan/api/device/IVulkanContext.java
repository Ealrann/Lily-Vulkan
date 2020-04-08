package org.sheepy.lily.vulkan.api.device;

import org.sheepy.lily.game.api.allocation.IGameAllocationContext;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;

public interface IVulkanContext extends IGameAllocationContext
{
	IWindow getWindow();
	IPhysicalDevice getPhysicalDevice();
	ILogicalDevice getLogicalDevice();
}
