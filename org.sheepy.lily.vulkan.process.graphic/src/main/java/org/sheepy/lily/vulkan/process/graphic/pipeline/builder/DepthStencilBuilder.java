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
		final var depthStencil = VkPipelineDepthStencilStateCreateInfo.callocStack(stack);
		depthStencil.sType(VK_STRUCTURE_TYPE_PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO);
		depthStencil.depthTestEnable(depthStencilState.isDepthTest());
		depthStencil.depthWriteEnable(depthStencilState.isDepthWrite());
		depthStencil.depthCompareOp(depthStencilState.getDepthCompareOp().getValue());
		depthStencil.depthBoundsTestEnable(depthStencilState.isDepthBoundTest());
		depthStencil.minDepthBounds(depthStencilState.getMinDepthBounds());
		depthStencil.maxDepthBounds(depthStencilState.getMaxDepthBounds());
		depthStencil.stencilTestEnable(depthStencilState.isStencilTest());

		depthStencil.pNext(VK_NULL_HANDLE);
		depthStencil.flags(0);

		return depthStencil;
	}
}
