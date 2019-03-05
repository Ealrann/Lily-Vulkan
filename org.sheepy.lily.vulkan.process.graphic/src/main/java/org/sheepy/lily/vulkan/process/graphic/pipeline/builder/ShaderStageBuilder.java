package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import java.util.List;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.resource.shader.ShaderAdapter;

public class ShaderStageBuilder
{
	private VkPipelineShaderStageCreateInfo.Buffer shaderStages = null;

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

	public void freeShaderStageInfo()
	{
		shaderStages.free();
		shaderStages = null;
	}
}
