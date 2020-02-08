package org.sheepy.lily.vulkan.core.resource;

public interface ISamplerAdapter extends IVulkanResourceAdapter
{
	long getSamplerPtr();
	long getViewPtr();
}
