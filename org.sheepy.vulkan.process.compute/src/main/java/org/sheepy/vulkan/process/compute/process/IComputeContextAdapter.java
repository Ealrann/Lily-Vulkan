package org.sheepy.vulkan.process.compute.process;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;

public interface IComputeContextAdapter extends IVulkanAdapter
{
	ComputeContext getComputeContext(EObject target);

	static IComputeContextAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IComputeContextAdapter.class);
	}
}
