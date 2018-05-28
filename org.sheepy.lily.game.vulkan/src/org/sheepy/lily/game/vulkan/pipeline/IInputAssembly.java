package org.sheepy.lily.game.vulkan.pipeline;

import org.lwjgl.vulkan.VkPipelineInputAssemblyStateCreateInfo;

public interface IInputAssembly
{
	VkPipelineInputAssemblyStateCreateInfo allocInputAssemblyStateCreateInfo();
	void freeInputAssemblyStateCreateInfo();
	void free();
}
