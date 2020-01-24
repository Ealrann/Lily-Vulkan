package org.sheepy.lily.vulkan.common.resource;

public interface ISamplerAdapter extends IVulkanResourceAdapter
{
	long getSamplerPtr();
	long getViewPtr();
}
