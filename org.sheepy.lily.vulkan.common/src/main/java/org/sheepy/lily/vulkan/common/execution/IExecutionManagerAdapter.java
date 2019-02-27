package org.sheepy.lily.vulkan.common.execution;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.IExecutionManager;

public interface IExecutionManagerAdapter extends IVulkanAdapter
{
	ExecutionContext getExecutionContext();

	static IExecutionManagerAdapter adapt(IExecutionManager executionManager)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(executionManager,
				IExecutionManagerAdapter.class);
	}
}
