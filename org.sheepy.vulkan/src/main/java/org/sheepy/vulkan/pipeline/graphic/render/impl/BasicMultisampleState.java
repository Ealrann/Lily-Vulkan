package org.sheepy.vulkan.pipeline.graphic.render.impl;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo;
import org.sheepy.vulkan.pipeline.graphic.render.IMultisampleState;

public class BasicMultisampleState implements IMultisampleState
{
	private VkPipelineMultisampleStateCreateInfo multisampling;

	@Override
	public VkPipelineMultisampleStateCreateInfo allocCreateInfo()
	{
		multisampling = VkPipelineMultisampleStateCreateInfo
				.calloc();
		multisampling.sType(VK_STRUCTURE_TYPE_PIPELINE_MULTISAMPLE_STATE_CREATE_INFO);
		multisampling.sampleShadingEnable(false);
		multisampling.rasterizationSamples(VK_SAMPLE_COUNT_1_BIT);
		multisampling.minSampleShading(1.0f); // Optional
		multisampling.pSampleMask(null); // Optional
		multisampling.alphaToCoverageEnable(false); // Optional
		multisampling.alphaToOneEnable(false); // Optional

		return multisampling;
	}

	@Override
	public void freeMultisampleStateCreateInfo()
	{
		multisampling.free();
	}

	@Override
	public void free()
	{
	}

}
