package org.sheepy.vulkan.pipeline.graphic.render;

import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;

public interface IInputAssembly
{
	VkPipelineInputAssemblyStateCreateInfo allocInputAssemblyStateCreateInfo();
	void freeInputAssemblyStateCreateInfo();
	void free();
}
