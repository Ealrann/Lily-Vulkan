package org.sheepy.lily.vulkan.api.allocation;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationNode;

public interface IAllocationNodeAdapter<T extends IAllocationContext>
		extends IAllocationNode<T>, IAllocationAdapter<T>
{
	static IAllocationNodeAdapter<?> adapt(EObject object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IAllocationNodeAdapter.class);
	}
}
