package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.queue.VulkanQueue;
import org.sheepy.vulkan.model.IProcessPool;

public interface IProcessPoolAdapter extends IVulkanAdapter
{
	VulkanQueue getQueue();

	void recordCommands();

	void execute();

	static IProcessPoolAdapter adapt(IProcessPool pool)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(pool, IProcessPoolAdapter.class);
	}
}
