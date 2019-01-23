package org.sheepy.lily.vulkan.api.adapter;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.window.IWindow;
import org.sheepy.lily.vulkan.model.VulkanEngine;

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
