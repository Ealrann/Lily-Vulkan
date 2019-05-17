package org.sheepy.lily.vulkan.api.process;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.queue.VulkanQueue;

public interface IProcessAdapter extends IVulkanAdapter
{
	void start(MemoryStack stack, IVulkanContext context);
	void stop(IVulkanContext context);

	void prepareNextAndExecute();
	
	Integer prepareNext();
	void execute(int next);

	VulkanQueue getQueue();

	static IProcessAdapter adapt(IProcess process)
	{
		return IAdapterFactoryService.INSTANCE.adapt(process, IProcessAdapter.class);
	}
}
