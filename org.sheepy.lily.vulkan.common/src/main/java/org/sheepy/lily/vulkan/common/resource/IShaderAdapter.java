package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.vulkan.pipeline.VkShaderStage;

public interface IShaderAdapter extends IVulkanResourceAdapter
{
	VkShaderStage getVkShaderStage();
}
