package org.sheepy.vulkan.processpool.compute;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;

public interface IComputeContextAdapter extends IVulkanAdapter
{
	ComputeContext getComputeContext();

	static IComputeContextAdapter adapt(EObject object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IComputeContextAdapter.class);
	}
}
