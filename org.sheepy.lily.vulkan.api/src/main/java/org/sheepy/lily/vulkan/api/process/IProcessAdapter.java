package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.vulkan.queue.VulkanQueue;

public interface IProcessAdapter extends IVulkanAdapter
{
	VulkanQueue getQueue();

	void prepareNextAndExecute();

	Integer prepareNext();

	void execute(int next);

	static IProcessAdapter adapt(IProcess process)
	{
		return IAdapterFactoryService.INSTANCE.adapt(process, IProcessAdapter.class);
	}
}
