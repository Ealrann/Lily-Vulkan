package org.sheepy.vulkan.pipeline;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;

public interface IShaderStageFiller
{
	void fillInfo(VkPipelineShaderStageCreateInfo info);
}
