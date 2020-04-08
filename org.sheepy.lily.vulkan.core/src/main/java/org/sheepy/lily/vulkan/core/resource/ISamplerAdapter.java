package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;

public interface ISamplerAdapter extends IAllocableAdapter<IVulkanContext>
{
	long getSamplerPtr();
	long getViewPtr();
}
