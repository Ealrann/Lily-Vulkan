package org.sheepy.lily.game.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collection;

import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.shader.Shader;

public class ComputePipeline
{

	private LogicalDevice logicalDevice;

	public ComputePipeline(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void load(DescriptorPool descriptorPool, Collection<Shader> shaders)
	{
		long[] aLayout = new long[1];
		VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo.calloc();
		pipelineLayoutCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		pipelineLayoutCreateInfo.pSetLayouts(descriptorPool.allocLayoutBuffer());
		if (vkCreatePipelineLayout(logicalDevice.getVkDevice(), pipelineLayoutCreateInfo, null,
				aLayout) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline layout!");
		}
		long pipelineLayout = aLayout[1];

		VkComputePipelineCreateInfo.Buffer pipelineCreateInfos = VkComputePipelineCreateInfo
				.calloc(shaders.size());

		for (Shader shader : shaders)
		{
			VkComputePipelineCreateInfo pipelineCreateInfo = pipelineCreateInfos.get();
			pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
			pipelineCreateInfo.stage(shader.allocInfo());
			pipelineCreateInfo.layout(pipelineLayout);
		}
		pipelineCreateInfos.flip();

		long[] aPipeline = new long[1];
		if (vkCreateComputePipelines(logicalDevice.getVkDevice(), VK_NULL_HANDLE,
				pipelineCreateInfos, null, aPipeline) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline!");
		}

		pipelineCreateInfos.free();
		pipelineLayoutCreateInfo.free();
	}
}
