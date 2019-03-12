package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;

public class InputAssemblyBuilder
{
	public VkPipelineInputAssemblyStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		var inputAssembly = VkPipelineInputAssemblyStateCreateInfo.mallocStack();
		inputAssembly.sType(VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
		inputAssembly.topology(VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST);
		inputAssembly.primitiveRestartEnable(false);
		inputAssembly.pNext(VK_NULL_HANDLE);
		inputAssembly.flags(0);

		return inputAssembly;
	}
}
