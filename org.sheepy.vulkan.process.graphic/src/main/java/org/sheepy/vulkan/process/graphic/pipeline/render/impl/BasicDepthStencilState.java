package org.sheepy.vulkan.process.graphic.pipeline.render.impl;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo;
import org.sheepy.vulkan.process.graphic.pipeline.render.IDepthStencilState;

public class BasicDepthStencilState implements IDepthStencilState
{

	private VkPipelineDepthStencilStateCreateInfo depthStencil;

	@Override
	public VkPipelineDepthStencilStateCreateInfo allocCreateInfo()
	{
		depthStencil = VkPipelineDepthStencilStateCreateInfo.calloc();
		depthStencil.sType(VK_STRUCTURE_TYPE_PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO);
		depthStencil.depthTestEnable(true);
		depthStencil.depthWriteEnable(true);
		depthStencil.depthCompareOp(VK_COMPARE_OP_LESS);
		depthStencil.depthBoundsTestEnable(false);
		depthStencil.minDepthBounds(0.0f); // Optional
		depthStencil.maxDepthBounds(1.0f); // Optional
		depthStencil.stencilTestEnable(false);

		return depthStencil;
	}

	@Override
	public void freeDepthStencilStateCreateInfo()
	{
		depthStencil.free();
	}

	@Override
	public void free()
	{}

}
