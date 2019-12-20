package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.vulkan.pipeline.VkShaderStage;

public interface IShaderAdapter extends IVulkanResourceAdapter
{
	VkShaderStage getVkShaderStage();
}
