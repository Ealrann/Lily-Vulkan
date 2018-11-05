package org.sheepy.vulkan.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;

public interface IFlatAllocableAdapter extends IAllocableAdapter
{
	/**
	 * Parents will be allocated first
	 */
	void flatAllocate(MemoryStack stack);
	
	static IFlatAllocableAdapter adapt(EObject object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IFlatAllocableAdapter.class);
	}
}
