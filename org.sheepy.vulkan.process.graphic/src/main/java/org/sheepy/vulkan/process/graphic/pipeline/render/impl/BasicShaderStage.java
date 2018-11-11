package org.sheepy.vulkan.process.graphic.pipeline.render.impl;

import java.util.List;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.model.resource.Shader;
import org.sheepy.vulkan.process.graphic.pipeline.render.IShaderStage;
import org.sheepy.vulkan.resource.shader.ShaderAdapter;

public class BasicShaderStage implements IShaderStage
{
	private VkPipelineShaderStageCreateInfo.Buffer shaderStages = null;

	@Override
	public VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(List<Shader> shaders)
	{
		if (shaders.isEmpty()) shaderStages = VkPipelineShaderStageCreateInfo.calloc(1);
		else
		{
			shaderStages = VkPipelineShaderStageCreateInfo.calloc(shaders.size());
			for (Shader shader : shaders)
			{
				var shaderAdapter = ShaderAdapter.adapt(shader);
				shaderAdapter.fillInfo(shaderStages.get());
			}
			shaderStages.flip();
		}

		return shaderStages;
	}

	@Override
	public void freeShaderStageInfo()
	{
		shaderStages.free();
	}

	@Override
	public void free()
	{}
}
