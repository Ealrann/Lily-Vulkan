package org.sheepy.lily.vulkan.api.allocation;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.vulkan.allocation.IAllocationNode;

public interface IAllocationDescriptorAdapter extends IAllocationAdapter, IAllocationNode
{
	static IAllocationDescriptorAdapter adapt(EObject object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IAllocationDescriptorAdapter.class);
	}
}
