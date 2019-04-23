package org.sheepy.vulkan.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.vulkan.window.Window;

public class VulkanContext implements IVulkanContext
{
	protected LogicalDevice logicalDevice;
	private Window window;

	public VulkanContext()
	{
		this(null, null);
	}

	public VulkanContext(LogicalDevice logicalDevice, Window window)
	{
		this.logicalDevice = logicalDevice;
		this.window = window;
	}

	@Override
	public void setLogicalDevice(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	@Override
	public void setWindow(Window window)
	{
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
