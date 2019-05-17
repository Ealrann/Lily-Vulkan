package org.sheepy.lily.vulkan.api.allocation;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationObject;

public interface IAllocationAdapter<T extends IAllocationContext>
		extends IVulkanAdapter, IAllocationObject<T>
{
	static IAllocationAdapter<?> adapt(EObject object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IAllocationAdapter.class);
	}
}
