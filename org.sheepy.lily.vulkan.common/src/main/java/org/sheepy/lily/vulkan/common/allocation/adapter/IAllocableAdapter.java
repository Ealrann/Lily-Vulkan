package org.sheepy.lily.vulkan.common.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;

public interface IAllocableAdapter extends IAllocable, IAllocationAdapter
{
	static IAllocableAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IAllocableAdapter.class);
	}
}
