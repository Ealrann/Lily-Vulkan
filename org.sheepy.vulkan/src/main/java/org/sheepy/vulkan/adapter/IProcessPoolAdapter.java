package org.sheepy.vulkan.adapter;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.execution.queue.VulkanQueue;
import org.sheepy.vulkan.model.process.AbstractProcessPool;

public interface IProcessPoolAdapter extends IDeepAllocableAdapter
{
	VulkanQueue getQueue();
	
	void execute();

	static IProcessPoolAdapter adapt(AbstractProcessPool<?> pool)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(pool, IProcessPoolAdapter.class);
	}
}
