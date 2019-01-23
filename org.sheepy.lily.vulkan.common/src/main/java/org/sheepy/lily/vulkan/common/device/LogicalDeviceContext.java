package org.sheepy.vulkan.common.device;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;

public class LogicalDeviceContext implements ILogicalDeviceContext
{
	public final LogicalDevice logicalDevice;

	public LogicalDeviceContext(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
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
