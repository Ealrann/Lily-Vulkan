package org.sheepy.vulkan.pipeline.graphic.render;

import java.util.List;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.model.Shader;

public interface IShaderStage
{
	VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(List<Shader> shaders);
	void freeShaderStageInfo();
	void free();
}
