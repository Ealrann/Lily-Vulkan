package org.sheepy.vulkan.pipeline.graphic.render.impl;

import java.util.List;

import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.pipeline.graphic.render.IShaderStage;
import org.sheepy.vulkan.resource.Shader;

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
				VkPipelineShaderStageCreateInfo shaderStageInfo = shader.allocInfo();
				shaderStages.put(shaderStageInfo);
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
	{
		// For now, let's suppose the shaders will be free by the user, with the
		// Mesh
	}
}
