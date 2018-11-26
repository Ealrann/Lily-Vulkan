package org.sheepy.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;

public class InputAssemblyBuilder
{
	private VkPipelineInputAssemblyStateCreateInfo inputAssembly;

	public VkPipelineInputAssemblyStateCreateInfo allocCreateInfo()
	{
		inputAssembly = VkPipelineInputAssemblyStateCreateInfo.calloc();
		inputAssembly.sType(VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
		inputAssembly.topology(VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST);
		inputAssembly.primitiveRestartEnable(false);

		return inputAssembly;
	}

	public void freeInputAssemblyStateCreateInfo()
	{
		inputAssembly.free();
	}
}
