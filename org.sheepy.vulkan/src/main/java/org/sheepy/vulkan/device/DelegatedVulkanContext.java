package org.sheepy.vulkan.device;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.vulkan.window.Window;

public class DelegatedVulkanContext implements IVulkanContext, IAllocable<IVulkanContext>
{
	private IVulkanContext context;

	public DelegatedVulkanContext()
	{}

	@Override
	public void allocate(IVulkanContext context)
	{
		this.context = context;
	}

	@Override
	public void free(IVulkanContext context)
	{
		this.context = null;
	}

	@Override
	public MemoryStack stack()
	{
		return context.stack();
	}

	@Override
	public void stackPop()
	{
		context.stackPop();
	}

	@Override
	public MemoryStack stackPush()
	{
		return context.stackPush();
	}

	@Override
	public Window getWindow()
	{
		return context.getWindow();
	}

	@Override
	public PhysicalDevice getPhysicalDevice()
	{
		return context.getPhysicalDevice();
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return context.getVkPhysicalDevice();
	}

	@Override
	public LogicalDevice getLogicalDevice()
	{
		return context.getLogicalDevice();
	}

	@Override
	public VkDevice getVkDevice()
	{
		return context.getVkDevice();
	}
}
