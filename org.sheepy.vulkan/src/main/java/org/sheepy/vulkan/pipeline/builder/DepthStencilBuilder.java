package org.sheepy.vulkan.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo;

public class DepthStencilBuilder
{
	public VkPipelineDepthStencilStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		final var depthStencil = VkPipelineDepthStencilStateCreateInfo.callocStack(stack);
		depthStencil.sType(VK_STRUCTURE_TYPE_PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO);
		depthStencil.depthTestEnable(true);
		depthStencil.depthWriteEnable(true);
		depthStencil.depthCompareOp(VK_COMPARE_OP_LESS);
		depthStencil.depthBoundsTestEnable(false);
		depthStencil.minDepthBounds(0.0f); // Optional
		depthStencil.maxDepthBounds(1.0f); // Optional
		depthStencil.stencilTestEnable(false);

		depthStencil.pNext(VK_NULL_HANDLE);
		depthStencil.flags(0);

		return depthStencil;
	}
}
