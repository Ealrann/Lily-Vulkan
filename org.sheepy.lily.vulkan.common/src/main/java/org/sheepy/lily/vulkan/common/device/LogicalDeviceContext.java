package org.sheepy.lily.vulkan.common.device;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;

public class LogicalDeviceContext implements ILogicalDeviceContext, IAllocationContext
{
	private LogicalDevice logicalDevice;

	public LogicalDeviceContext()
	{
		this(null);
	}

	public LogicalDeviceContext(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void setLogicalDevice(LogicalDevice logicalDevice)
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

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{}

	@Override
	public void free(IAllocationContext context)
	{}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
