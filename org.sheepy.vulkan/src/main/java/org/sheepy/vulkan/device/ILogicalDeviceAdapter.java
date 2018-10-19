package org.sheepy.vulkan.device;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;

public interface ILogicalDeviceAdapter extends IVulkanAdapter, ILogicalDeviceContext
{
	static ILogicalDeviceAdapter adapt(EObject object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, ILogicalDeviceAdapter.class);
	}
}
