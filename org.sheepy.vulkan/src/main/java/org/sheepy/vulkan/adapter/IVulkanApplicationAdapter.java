package org.sheepy.vulkan.adapter;

import org.sheepy.common.api.adapter.IStatefullAdapter;
import org.sheepy.vulkan.model.process.AbstractProcessPool;

public interface IVulkanApplicationAdapter extends IVulkanAdapter, IStatefullAdapter
{
	void close();
	
	void prepare();
	
	void execute(AbstractProcessPool<?> processPool);
	
	boolean shouldClose();
}
