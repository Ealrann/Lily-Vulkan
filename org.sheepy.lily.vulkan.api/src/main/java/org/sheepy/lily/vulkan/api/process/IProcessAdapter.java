package org.sheepy.lily.vulkan.api.process;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;

public interface IProcessAdapter extends IVulkanAdapter
{
	VulkanQueue getQueue();

	void execute();

	static IProcessAdapter adapt(EObject process)
	{
		return IAdapterFactoryService.INSTANCE.adapt(process, IProcessAdapter.class);
	}
}
