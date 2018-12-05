package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.IStatefullAdapter;
import org.sheepy.vulkan.api.window.IWindow;

public interface IVulkanApplicationAdapter extends IVulkanAdapter, IStatefullAdapter
{
	void close();
	
	void pollEvents();

	IWindow getWindow();
}
