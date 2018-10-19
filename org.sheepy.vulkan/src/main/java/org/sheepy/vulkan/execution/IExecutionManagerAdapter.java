package org.sheepy.vulkan.execution;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;

public interface IExecutionManagerAdapter extends IVulkanAdapter
{
	ExecutionManager getExecutionManager();

	static IExecutionManagerAdapter adapt(EObject object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IExecutionManagerAdapter.class);
	}
}
