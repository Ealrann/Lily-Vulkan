package org.sheepy.vulkan.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;

public interface IFlatAllocableAdapter extends IAllocableAdapter
{
	/**
	 * Parents will be allocated first
	 */
	void flatAllocate(MemoryStack stack);
	
	public static IFlatAllocableAdapter adapt(EObject object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IFlatAllocableAdapter.class);
	}
}
