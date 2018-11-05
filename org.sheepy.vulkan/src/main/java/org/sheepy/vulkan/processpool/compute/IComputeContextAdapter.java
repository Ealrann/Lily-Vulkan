package org.sheepy.vulkan.processpool.compute;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.adapter.IVulkanAdapter;

public interface IComputeContextAdapter extends IVulkanAdapter
{
	ComputeContext getComputeContext(EObject target);

	static IComputeContextAdapter adapt(EObject object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IComputeContextAdapter.class);
	}
}
