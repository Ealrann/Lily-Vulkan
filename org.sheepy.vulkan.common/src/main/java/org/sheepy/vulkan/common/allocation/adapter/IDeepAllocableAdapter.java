package org.sheepy.vulkan.common.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;

public interface IDeepAllocableAdapter extends IAllocableAdapter
{
	/**
	 * Children will be allocated first
	 */
	void deepAllocate(MemoryStack stack);
	
	static IDeepAllocableAdapter adapt(EObject object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IDeepAllocableAdapter.class);
	}
}
