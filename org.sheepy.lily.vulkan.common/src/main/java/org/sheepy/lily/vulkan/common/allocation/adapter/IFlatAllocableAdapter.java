package org.sheepy.lily.vulkan.common.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;

public interface IFlatAllocableAdapter extends IAllocableAdapter
{
	/**
	 * Parents will be allocated first
	 */
	void flatAllocate(MemoryStack stack);

	static IFlatAllocableAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IFlatAllocableAdapter.class);
	}
}
