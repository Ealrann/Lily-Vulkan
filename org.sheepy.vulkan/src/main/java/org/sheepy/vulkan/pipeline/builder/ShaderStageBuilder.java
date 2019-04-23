package org.sheepy.vulkan.pipeline.builder;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.pipeline.IShaderStageFiller;

public class ShaderStageBuilder
{
	public VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(	MemoryStack stack,
																		List<IShaderStageFiller> shaderFillers)
	{
		VkPipelineShaderStageCreateInfo.Buffer shaderStages = null;

		if (shaderFillers.isEmpty())
		{
			shaderStages = VkPipelineShaderStageCreateInfo.callocStack(1, stack);
		}
		else
		{
			shaderStages = VkPipelineShaderStageCreateInfo.callocStack(shaderFillers.size(), stack);
			for (final var shaderFiller : shaderFillers)
			{
				shaderFiller.fillInfo(shaderStages.get());
			}
			shaderStages.flip();
		}

		return shaderStages;
	}
}
