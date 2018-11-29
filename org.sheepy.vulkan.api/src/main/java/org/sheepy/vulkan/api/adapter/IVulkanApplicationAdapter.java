package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.IStatefullAdapter;
import org.sheepy.vulkan.api.window.IWindow;
import org.sheepy.vulkan.model.IProcessPool;

public interface IVulkanApplicationAdapter extends IVulkanAdapter, IStatefullAdapter
{
	void close();
	
	void prepare();
	
	void execute(IProcessPool processPool);
	
	boolean shouldClose();

	IWindow getWindow();
}
