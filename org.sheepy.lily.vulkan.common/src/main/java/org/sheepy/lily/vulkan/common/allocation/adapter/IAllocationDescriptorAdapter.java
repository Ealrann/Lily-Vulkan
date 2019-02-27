package org.sheepy.lily.vulkan.common.allocation.adapter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;

public interface IAllocationDescriptorAdapter extends IAllocationAdapter
{
	List<Object> getAllocationList();

	static IAllocationDescriptorAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IAllocationDescriptorAdapter.class);
	}
}
