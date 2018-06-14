package org.sheepy.lily.game.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;

public interface IInputAssembly
{
	VkPipelineInputAssemblyStateCreateInfo allocInputAssemblyStateCreateInfo();
	void freeInputAssemblyStateCreateInfo();
	void free();
}
