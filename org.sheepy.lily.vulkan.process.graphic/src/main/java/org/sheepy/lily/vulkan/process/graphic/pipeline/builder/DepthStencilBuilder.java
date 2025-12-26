package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;

public class DepthStencilBuilder
{
	public VkPipelineDepthStencilStateCreateInfo allocCreateInfo(	MemoryStack stack,
																	DepthStencilState depthStencilState)
	{
		final var depthStencil = VkPipelineDepthStencilStateCreateInfo.calloc(stack);
		depthStencil.sType(VK_STRUCTURE_TYPE_PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO);
		depthStencil.depthTestEnable(depthStencilState.depthTest());
		depthStencil.depthWriteEnable(depthStencilState.depthWrite());
		depthStencil.depthCompareOp(depthStencilState.depthCompareOp().value());
		depthStencil.depthBoundsTestEnable(depthStencilState.depthBoundTest());
		depthStencil.minDepthBounds(depthStencilState.minDepthBounds());
		depthStencil.maxDepthBounds(depthStencilState.maxDepthBounds());
		depthStencil.stencilTestEnable(depthStencilState.stencilTest());

		depthStencil.pNext(VK_NULL_HANDLE);
		depthStencil.flags(0);

		return depthStencil;
	}
}
