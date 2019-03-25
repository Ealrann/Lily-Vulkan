package org.sheepy.lily.vulkan.api.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;

public interface IAllocableAdapter extends IAllocable, IAllocationAdapter
{
	static IAllocableAdapter adapt(EObject object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IAllocableAdapter.class);
	}
}
