package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.vulkan.pipeline.VkShaderStage;

public interface IShaderAdapter extends IResourceAdapter
{
	long getShaderModule();

	VkShaderStage getVkShaderStage();
}
