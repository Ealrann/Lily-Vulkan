package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.resource.shader.ShaderAdapter;

public class ShaderStageBuilder
{
	public VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(	MemoryStack stack,
																		List<Shader> shaders)
	{
		VkPipelineShaderStageCreateInfo.Buffer shaderStages = null;

		if (shaders.isEmpty())
		{
			shaderStages = VkPipelineShaderStageCreateInfo.callocStack(1, stack);
		}
		else
		{
			shaderStages = VkPipelineShaderStageCreateInfo.callocStack(shaders.size(), stack);
			for (Shader shader : shaders)
			{
				var shaderAdapter = ShaderAdapter.adapt(shader);
				shaderAdapter.fillInfo(shaderStages.get());
			}
			shaderStages.flip();
		}

		return shaderStages;
	}
}
