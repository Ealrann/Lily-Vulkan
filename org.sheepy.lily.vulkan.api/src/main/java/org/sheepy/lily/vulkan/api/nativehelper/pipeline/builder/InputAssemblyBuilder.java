package org.sheepy.lily.vulkan.api.nativehelper.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;
import org.sheepy.lily.vulkan.model.process.graphic.InputAssembly;

public class InputAssemblyBuilder
{
	public VkPipelineInputAssemblyStateCreateInfo allocCreateInfo(MemoryStack stack, InputAssembly info)
	{
		final var inputAssembly = VkPipelineInputAssemblyStateCreateInfo.mallocStack();
		inputAssembly.sType(VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
		inputAssembly.topology(info.getPrimitiveTopology().getValue());
		inputAssembly.primitiveRestartEnable(info.isPrimitiveRestartEnabled());
		inputAssembly.pNext(VK_NULL_HANDLE);
		inputAssembly.flags(0);

		return inputAssembly;
	}
}
