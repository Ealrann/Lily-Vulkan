package org.sheepy.lily.vulkan.common.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationObject;

public interface IAllocationAdapter extends IVulkanAdapter, IAllocationObject
{
	static IAllocationAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IAllocationAdapter.class);
	}
}
