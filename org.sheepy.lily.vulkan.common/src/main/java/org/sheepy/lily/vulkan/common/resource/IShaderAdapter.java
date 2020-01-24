package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.vulkan.common.pipeline.VkShaderStage;

public interface IShaderAdapter extends IVulkanResourceAdapter
{
	VkShaderStage getVkShaderStage();
}
