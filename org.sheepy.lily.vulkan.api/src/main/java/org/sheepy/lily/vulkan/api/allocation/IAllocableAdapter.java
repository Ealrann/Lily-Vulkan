package org.sheepy.lily.vulkan.api.allocation;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;

public interface IAllocableAdapter<T extends IAllocationContext>
		extends IAllocable<T>, IAllocationAdapter<T>
{
	static IAllocableAdapter<?> adapt(EObject object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IAllocableAdapter.class);
	}
}
