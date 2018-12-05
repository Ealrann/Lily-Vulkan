package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.window.IWindow;
import org.sheepy.vulkan.model.VulkanEngine;

public interface IVulkanEngineAdapter extends IVulkanAdapter
{
	void start();
	void stop();
	void pollEvents();
	IWindow getWindow();

	static IVulkanEngineAdapter adapt(VulkanEngine engine)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(engine, IVulkanEngineAdapter.class);
	}
}
