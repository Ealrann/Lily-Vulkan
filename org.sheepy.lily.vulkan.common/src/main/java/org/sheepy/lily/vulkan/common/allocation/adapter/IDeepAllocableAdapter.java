package org.sheepy.lily.vulkan.common.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;

public interface IDeepAllocableAdapter extends IAllocableAdapter
{
	/**
	 * Children will be allocated first
	 */
	void deepAllocate(MemoryStack stack);

	static IDeepAllocableAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IDeepAllocableAdapter.class);
	}
}
