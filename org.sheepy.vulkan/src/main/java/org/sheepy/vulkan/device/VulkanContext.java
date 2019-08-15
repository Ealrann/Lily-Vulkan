package org.sheepy.vulkan.device;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.vulkan.window.Window;

public class VulkanContext implements IVulkanContext
{
	private final Window window;
	protected final LogicalDevice logicalDevice;

	private MemoryStack stack = null;

	public VulkanContext(LogicalDevice logicalDevice, Window window)
	{
		this.logicalDevice = logicalDevice;
		this.window = window;
	}

	@Override
	public MemoryStack stackPush()
	{
		if (stack != null)
		{
			stack.pop();
		}

		stack = MemoryStack.stackPush();

		return stack;
	}

	@Override
	public void stackPop()
	{
		if (stack != null)
		{
			stack.pop();
			stack = null;
		}
	}

	@Override
	public MemoryStack stack()
	{
		if (stack == null)
		{
			stackPush();
		}
		return stack;
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
