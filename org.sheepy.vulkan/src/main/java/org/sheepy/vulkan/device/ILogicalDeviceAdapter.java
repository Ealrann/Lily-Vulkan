package org.sheepy.vulkan.device;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.adapter.IVulkanAdapter;

public interface ILogicalDeviceAdapter extends IVulkanAdapter
{
	PhysicalDevice getPhysicalDevice(EObject target);

	VkPhysicalDevice getVkPhysicalDevice(EObject target);
	
	LogicalDevice getLogicalDevice(EObject target);

	VkDevice getVkDevice(EObject target);
	
	static ILogicalDeviceAdapter adapt(EObject object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, ILogicalDeviceAdapter.class);
	}
}
