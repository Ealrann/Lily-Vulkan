package org.sheepy.vulkan.common.application;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.common.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.device.PhysicalDevice;
import org.sheepy.vulkan.common.engine.VulkanEngineAdapter;
import org.sheepy.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.model.VulkanPackage;

public class LogicalDeviceAdapter extends AbstractSingletonAdapter implements ILogicalDeviceAdapter
{
	@Override
	public PhysicalDevice getPhysicalDevice(EObject target)
	{
		return retrieveManager(target).getPhysicalDevice();
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice(EObject target)
	{
		return retrieveManager(target).getPhysicalDevice().vkPhysicalDevice;
	}

	@Override
	public LogicalDevice getLogicalDevice(EObject target)
	{
		return retrieveManager(target).getLogicalDevice();
	}

	@Override
	public VkDevice getVkDevice(EObject target)
	{
		return retrieveManager(target).getLogicalDevice().getVkDevice();
	}

	private static VulkanEngineAdapter retrieveManager(EObject target)
	{
		while (target.eClass() != VulkanPackage.Literals.VULKAN_ENGINE)
		{
			target = target.eContainer();
		}

		return VulkanEngineAdapter.adapt((VulkanEngine) target);
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}
}
