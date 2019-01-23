package org.sheepy.lily.vulkan.common.device;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;

public interface ILogicalDeviceAdapter extends IVulkanAdapter
{
	PhysicalDevice getPhysicalDevice(EObject target);

	VkPhysicalDevice getVkPhysicalDevice(EObject target);

	LogicalDevice getLogicalDevice(EObject target);

	VkDevice getVkDevice(EObject target);

	static ILogicalDeviceAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ILogicalDeviceAdapter.class);
	}
}
