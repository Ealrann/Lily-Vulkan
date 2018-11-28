package org.sheepy.vulkan.common.application;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.common.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.device.PhysicalDevice;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.VulkanPackage;

public class LogicalDeviceAdapter extends AbstractSingletonAdapter
		implements ILogicalDeviceAdapter
{
	@Override
	public PhysicalDevice getPhysicalDevice(EObject target)
	{
		return retrieveManager(target).physicalDevice;
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice(EObject target)
	{
		return retrieveManager(target).physicalDevice.vkPhysicalDevice;
	}

	@Override
	public LogicalDevice getLogicalDevice(EObject target)
	{
		return retrieveManager(target).logicalDevice;
	}

	@Override
	public VkDevice getVkDevice(EObject target)
	{
		return retrieveManager(target).logicalDevice.getVkDevice();
	}

	private static VulkanApplicationManager retrieveManager(EObject target)
	{
		while (target.eClass() != VulkanPackage.Literals.VULKAN_APPLICATION)
		{
			target = target.eContainer();
		}

		return VulkanApplicationAdapter.adapt((VulkanApplication) target).manager;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}
}
