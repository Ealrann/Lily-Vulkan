package org.sheepy.lily.vulkan.common.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.device.ILogicalDevice;
import org.sheepy.lily.vulkan.api.device.IPhysicalDevice;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.api.process.IVulkanContext;

public class VulkanContext implements IVulkanContext, IAllocationContext
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

	public void setLogicalDevice(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

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
	public IPhysicalDevice getPhysicalDevice()
	{
		return logicalDevice.physicalDevice;
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return logicalDevice.physicalDevice.vkPhysicalDevice;
	}

	@Override
	public ILogicalDevice getLogicalDevice()
	{
		return logicalDevice;
	}

	@Override
	public VkDevice getVkDevice()
	{
		return logicalDevice.getVkDevice();
	}
}
