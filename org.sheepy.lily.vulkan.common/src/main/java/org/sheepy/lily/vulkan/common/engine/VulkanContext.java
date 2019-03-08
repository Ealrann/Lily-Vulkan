package org.sheepy.lily.vulkan.common.engine;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;

public class VulkanContext implements IVulkanContext, IAllocationContext
{
	private LogicalDevice logicalDevice;
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
