package org.sheepy.vulkan.adapter;

import org.sheepy.vulkan.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.execution.queue.VulkanQueue;
import org.sheepy.vulkan.model.process.AbstractProcessPool;

public interface IProcessPoolAdapter extends IDeepAllocableAdapter
{
	VulkanQueue getQueue();
	
	void execute();

	static IProcessPoolAdapter adapt(AbstractProcessPool<?> pool)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(pool, IProcessPoolAdapter.class);
	}
}
