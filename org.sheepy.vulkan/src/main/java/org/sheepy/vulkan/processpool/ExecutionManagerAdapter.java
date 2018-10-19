package org.sheepy.vulkan.processpool;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.execution.ExecutionManager;
import org.sheepy.vulkan.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.model.AbstractProcessPool;
import org.sheepy.vulkan.model.VulkanPackage;

public class ExecutionManagerAdapter extends AbstractSheepyAdapter
		implements IExecutionManagerAdapter
{
	@Override
	public ExecutionManager getExecutionManager()
	{
		var current = target;
		while (!VulkanPackage.Literals.ABSTRACT_PROCESS_POOL.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return AbstractProcessPoolAdapter.adapt((AbstractProcessPool<?>) current).executionManager;
	}
}
