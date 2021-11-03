package org.sheepy.lily.vulkan.process.pipeline.builder;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;

public class ShaderStageBuilder
{
	public VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(	MemoryStack stack,
																		List<VkShaderStage> vkShaderStages,
																		ByteBuffer specializationData)
	{
		VkPipelineShaderStageCreateInfo.Buffer shaderStages = null;

		if (vkShaderStages.isEmpty())
		{
			shaderStages = VkPipelineShaderStageCreateInfo.calloc(1, stack);
		}
		else
		{
			shaderStages = VkPipelineShaderStageCreateInfo.calloc(vkShaderStages.size(),
					stack);
			for (final var shaderStage : vkShaderStages)
			{
				shaderStage.fillInfo(stack, shaderStages.get(), specializationData);
			}
			shaderStages.flip();
		}

		return shaderStages;
	}
}
