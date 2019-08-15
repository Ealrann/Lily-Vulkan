package org.sheepy.lily.vulkan.api.allocation;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;

public interface IAllocableAdapter<T extends IAllocationContext>
		extends IAllocable<T>, IVulkanAdapter
{
	static IAllocableAdapter<?> adapt(EObject object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IAllocableAdapter.class);
	}
}
