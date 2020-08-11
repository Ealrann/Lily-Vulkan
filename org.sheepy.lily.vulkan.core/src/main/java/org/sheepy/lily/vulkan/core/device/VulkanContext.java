package org.sheepy.lily.vulkan.core.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.vulkan.core.window.Window;

public class VulkanContext extends GameAllocationContext implements IVulkanContext
{
	private final VkInstance vkInstance;
	private final PhysicalDevice physicalDevice;
	private final LogicalDevice logicalDevice;
	private final Window window;

	public VulkanContext(IVulkanContext vulkanContext)
	{
		this.vkInstance = vulkanContext.getVkInstance();
		this.physicalDevice = vulkanContext.getPhysicalDevice();
		this.logicalDevice = vulkanContext.getLogicalDevice();
		this.window = vulkanContext.getWindow();
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
		return physicalDevice.vkPhysicalDevice;
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

	@Override
	public VkInstance getVkInstance()
	{
		return vkInstance;
	}
}