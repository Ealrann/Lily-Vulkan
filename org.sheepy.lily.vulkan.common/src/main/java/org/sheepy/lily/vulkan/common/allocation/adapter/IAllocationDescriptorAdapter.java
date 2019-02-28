package org.sheepy.lily.vulkan.common.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationNode;

public interface IAllocationDescriptorAdapter extends IAllocationAdapter, IAllocationNode
{
	static IAllocationDescriptorAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IAllocationDescriptorAdapter.class);
	}
}
