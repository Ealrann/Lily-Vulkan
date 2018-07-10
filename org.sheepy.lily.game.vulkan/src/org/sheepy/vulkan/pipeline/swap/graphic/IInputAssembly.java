package org.sheepy.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;

public interface IInputAssembly
{
	VkPipelineInputAssemblyStateCreateInfo allocInputAssemblyStateCreateInfo();
	void freeInputAssemblyStateCreateInfo();
	void free();
}
