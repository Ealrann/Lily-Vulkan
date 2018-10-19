package org.sheepy.vulkan.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.allocation.IAllocable;

public interface IAllocableAdapter extends IVulkanAdapter, IAllocable
{
	public static IAllocableAdapter adapt(EObject object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IAllocableAdapter.class);
	}
}
