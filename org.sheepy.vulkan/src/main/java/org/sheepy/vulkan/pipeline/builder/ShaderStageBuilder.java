package org.sheepy.vulkan.pipeline.builder;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.pipeline.VkShaderStage;

public class ShaderStageBuilder
{
	public VkPipelineShaderStageCreateInfo.Buffer allocShaderStageInfo(	MemoryStack stack,
																		List<VkShaderStage> vkShaderStages,
																		ByteBuffer specializationData)
	{
		VkPipelineShaderStageCreateInfo.Buffer shaderStages = null;

		if (vkShaderStages.isEmpty())
		{
			shaderStages = VkPipelineShaderStageCreateInfo.callocStack(1, stack);
		}
		else
		{
			shaderStages = VkPipelineShaderStageCreateInfo.callocStack(vkShaderStages.size(),
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
