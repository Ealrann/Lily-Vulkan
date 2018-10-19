package org.sheepy.vulkan.application;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.device.PhysicalDevice;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.VulkanPackage;

public class LogicalDeviceAdapter extends AbstractSheepyAdapter implements ILogicalDeviceAdapter
{
	@Override
	public PhysicalDevice getPhysicalDevice()
	{
		return retrieveManager().physicalDevice;
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return retrieveManager().physicalDevice.vkPhysicalDevice;
	}

	@Override
	public LogicalDevice getLogicalDevice()
	{
		return retrieveManager().logicalDevice;
	}

	@Override
	public VkDevice getVkDevice()
	{
		return retrieveManager().logicalDevice.getVkDevice();
	}

	private VulkanApplicationManager retrieveManager()
	{
		var current = target;
		while (current.eClass() != VulkanPackage.Literals.VULKAN_APPLICATION)
		{
			current = current.eContainer();
		}

		return VulkanApplicationAdapter.adapt((VulkanApplication) current).manager;
	}
}
