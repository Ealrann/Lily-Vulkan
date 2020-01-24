package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;

public class RasterizerBuilder
{
	public VkPipelineRasterizationStateCreateInfo allocCreateInfo(	MemoryStack stack,
																	Rasterizer rasterizer)
	{
		final var rasterizerInfo = VkPipelineRasterizationStateCreateInfo.mallocStack(stack);
		rasterizerInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
		rasterizerInfo.rasterizerDiscardEnable(rasterizer.isDiscardEnable());
		rasterizerInfo.polygonMode(rasterizer.getPolygonMode().getValue());
		rasterizerInfo.lineWidth(rasterizer.getLineWidth());
		rasterizerInfo.cullMode(rasterizer.getCullMode().getValue());
		rasterizerInfo.frontFace(rasterizer.getFrontFace().getValue());
		rasterizerInfo.depthBiasEnable(rasterizer.isDepthBiasEnable());
		rasterizerInfo.depthBiasConstantFactor(0.0f);
		rasterizerInfo.depthClampEnable(rasterizer.isDepthClampEnable());
		rasterizerInfo.depthBiasClamp(0.0f);
		rasterizerInfo.depthBiasSlopeFactor(0.0f);

		rasterizerInfo.pNext(VK_NULL_HANDLE);
		rasterizerInfo.flags(0);

		return rasterizerInfo;
	}
}
