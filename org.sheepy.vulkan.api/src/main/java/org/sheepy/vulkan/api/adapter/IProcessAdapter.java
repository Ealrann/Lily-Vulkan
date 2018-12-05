package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.queue.VulkanQueue;
import org.sheepy.vulkan.model.IProcess;

public interface IProcessAdapter extends IVulkanAdapter
{
	VulkanQueue getQueue();

	void allocateProcess();
	void freeProcess();
	
	void prepare();
	void execute();

	static IProcessAdapter adapt(IProcess process)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(process, IProcessAdapter.class);
	}
}
