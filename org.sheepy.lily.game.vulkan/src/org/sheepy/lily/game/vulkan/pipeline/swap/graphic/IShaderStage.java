package org.sheepy.lily.game.vulkan.pipeline.swap.graphic;

import java.util.List;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.game.vulkan.shader.Shader;

public interface IShaderStage
{
	VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(List<Shader> shaders);
	void freeShaderStageInfo();
	void free();
}
