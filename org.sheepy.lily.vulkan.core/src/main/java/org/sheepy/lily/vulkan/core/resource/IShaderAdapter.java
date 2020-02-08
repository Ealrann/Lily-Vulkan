package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;

public interface IShaderAdapter extends IVulkanResourceAdapter
{
	VkShaderStage getVkShaderStage();
}
