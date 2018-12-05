package org.sheepy.vulkan.api.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.queue.VulkanQueue;

public interface IProcessAdapter extends IEnginePartAdapter
{
	VulkanQueue getQueue();
	
	void prepare();
	void execute();

	static IProcessAdapter adapt(EObject process)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(process, IProcessAdapter.class);
	}
}
