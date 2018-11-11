package org.sheepy.vulkan.process.graphic.pipeline.render;

import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;

public interface IInputAssembly
{
	VkPipelineInputAssemblyStateCreateInfo allocCreateInfo();
	void freeInputAssemblyStateCreateInfo();
	void free();
}
