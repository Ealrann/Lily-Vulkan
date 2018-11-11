package org.sheepy.vulkan.process.graphic.pipeline.render;

import java.util.List;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.model.resource.Shader;

public interface IShaderStage
{
	VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(List<Shader> shaders);
	void freeShaderStageInfo();
	void free();
}
