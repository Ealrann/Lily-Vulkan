package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.window.IWindow;
import org.sheepy.vulkan.model.VulkanEngine;

public interface IVulkanEngineAdapter extends IVulkanAdapter
{
	void start();
	void stop();
	void pollEvents();
	void allocate();
	void free();
	IWindow getWindow();

	static IVulkanEngineAdapter adapt(VulkanEngine engine)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(engine, IVulkanEngineAdapter.class);
	}
}
