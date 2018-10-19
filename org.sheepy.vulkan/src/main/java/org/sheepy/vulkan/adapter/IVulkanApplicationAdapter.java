package org.sheepy.vulkan.adapter;

import org.sheepy.vulkan.model.AbstractProcessPool;

public interface IVulkanApplicationAdapter extends IVulkanAdapter
{

	void close();
	
	void prepare();
	
	void execute(AbstractProcessPool<?> processPool);
	
	boolean shouldClose();
}
