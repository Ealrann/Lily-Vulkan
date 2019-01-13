package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.engine.IEngineAdapter;
import org.sheepy.vulkan.api.concurrent.IFence;
import org.sheepy.vulkan.api.window.IWindow;
import org.sheepy.vulkan.model.VulkanEngine;

public interface IVulkanEngineAdapter extends IEngineAdapter, IVulkanAdapter
{
	void start();
	void stop();
	void allocate();
	void free();

	IWindow getWindow();

	IFence newFence();
	IFence newFence(boolean signaled);

	static IVulkanEngineAdapter adapt(VulkanEngine engine)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(engine, IVulkanEngineAdapter.class);
	}
}
