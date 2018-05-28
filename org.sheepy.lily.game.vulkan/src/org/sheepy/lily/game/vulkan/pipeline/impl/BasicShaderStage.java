package org.sheepy.lily.game.vulkan.pipeline.impl;

import java.util.List;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.game.vulkan.pipeline.IShaderStage;
import org.sheepy.lily.game.vulkan.shader.Shader;

public class BasicShaderStage implements IShaderStage
{
	private VkPipelineShaderStageCreateInfo.Buffer shaderStages;

	@Override
	public VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(List<Shader> shaders)
	{
		shaderStages = VkPipelineShaderStageCreateInfo.calloc(shaders.size());
		for (Shader shader : shaders)
		{
			VkPipelineShaderStageCreateInfo shaderStageInfo = shader.allocInfo();
			shaderStages.put(shaderStageInfo);
		}
		shaderStages.flip();

		return shaderStages;
	}

	@Override
	public void freeShaderStageInfo()
	{
		shaderStages.free();
	}

	@Override
	public void free()
	{
		// For now, let's suppose the shaders will be free by the user, with the Mesh
	}
}
