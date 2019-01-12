package org.sheepy.vulkan.api.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.concurrent.IFence;
import org.sheepy.vulkan.api.concurrent.ISignalEmitter;
import org.sheepy.vulkan.api.queue.VulkanQueue;

public interface IProcessAdapter extends IEnginePartAdapter, ISignalEmitter
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
