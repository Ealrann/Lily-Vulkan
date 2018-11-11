package org.sheepy.vulkan.process.graphic.pipeline.render;

import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;
import org.sheepy.vulkan.model.process.graphic.GraphicConfiguration;

public interface IRasterizer
{
	VkPipelineRasterizationStateCreateInfo allocCreateInfo(GraphicConfiguration context);

	void freeRasterizationStateCreateInfo();

	void free();
}
