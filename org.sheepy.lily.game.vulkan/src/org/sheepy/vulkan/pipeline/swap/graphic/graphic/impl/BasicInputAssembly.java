package org.sheepy.vulkan.pipeline.swap.graphic.graphic.impl;

import static org.lwjgl.vulkan.VK10.VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO;

import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;
import org.sheepy.vulkan.pipeline.swap.graphic.IInputAssembly;

public class BasicInputAssembly implements IInputAssembly
{
	private VkPipelineInputAssemblyStateCreateInfo inputAssembly;

	@Override
	public VkPipelineInputAssemblyStateCreateInfo allocInputAssemblyStateCreateInfo()
	{
		inputAssembly = VkPipelineInputAssemblyStateCreateInfo.calloc();
		inputAssembly.sType(VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
		inputAssembly.topology(VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST);
		inputAssembly.primitiveRestartEnable(false);

		return inputAssembly;
	}

	@Override
	public void freeInputAssemblyStateCreateInfo()
	{
		inputAssembly.free();
	}

	@Override
	public void free()
	{
	}
}
