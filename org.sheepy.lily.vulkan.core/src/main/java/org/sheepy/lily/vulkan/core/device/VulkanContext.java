package org.sheepy.lily.vulkan.core.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.vulkan.core.window.Window;

public class VulkanContext extends GameAllocationContext implements InternalVulkanContext
{
	private final Window window;
	private final LogicalDevice logicalDevice;

	public VulkanContext(LogicalDevice logicalDevice, Window window)
	{
		this.logicalDevice = logicalDevice;
		this.window = window;
	}

	@Override
	public Window getWindow()
	{
		return window;
	}

	@Override
	public PhysicalDevice getPhysicalDevice()
	{
		return logicalDevice.physicalDevice;
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return logicalDevice.physicalDevice.vkPhysicalDevice;
	}

	@Override
	public LogicalDevice getLogicalDevice()
	{
		return logicalDevice;
	}

	@Override
	public VkDevice getVkDevice()
	{
		return logicalDevice.getVkDevice();
	}
}
