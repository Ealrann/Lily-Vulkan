package org.sheepy.vulkan.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;

public interface IDeepAllocableAdapter extends IAllocableAdapter
{
	/**
	 * Children will be allocated first
	 */
	void deepAllocate(MemoryStack stack);
	
	public static IDeepAllocableAdapter adapt(EObject object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IDeepAllocableAdapter.class);
	}
}
