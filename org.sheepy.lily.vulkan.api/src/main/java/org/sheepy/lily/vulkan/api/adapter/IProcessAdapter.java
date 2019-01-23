package org.sheepy.lily.vulkan.api.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;

public interface IProcessAdapter extends IEnginePartAdapter
{
	VulkanQueue getQueue();

	void prepare();

	void execute();
	void execute(IFence fence);

	static IProcessAdapter adapt(EObject process)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(process, IProcessAdapter.class);
	}
}
