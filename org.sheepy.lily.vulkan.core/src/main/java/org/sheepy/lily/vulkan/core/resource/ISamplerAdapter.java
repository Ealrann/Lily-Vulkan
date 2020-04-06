package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.core.device.VulkanContext;

public interface ISamplerAdapter extends IAllocableAdapter<VulkanContext>
{
	long getSamplerPtr();
	long getViewPtr();
}
