package org.sheepy.lily.vulkan.common.execution;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;

public interface IExecutionManagerAdapter extends IVulkanAdapter
{
	ExecutionManager getExecutionManager(EObject target);

	static IExecutionManagerAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IExecutionManagerAdapter.class);
	}
}
