package org.sheepy.vulkan.processpool.compute;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.model.ComputeProcessPool;
import org.sheepy.vulkan.model.VulkanPackage;

public class ComputeContextAdapter extends AbstractSheepyAdapter implements IComputeContextAdapter
{
	@Override
	public ComputeContext getComputeContext()
	{
		var current = target;
		while (!VulkanPackage.Literals.COMPUTE_PROCESS_POOL.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return ComputeProcessPoolAdapter.adapt((ComputeProcessPool) current).context;
	}
}
