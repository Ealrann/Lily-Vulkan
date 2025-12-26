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
		final var rasterizerInfo = VkPipelineRasterizationStateCreateInfo.malloc(stack);
		rasterizerInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
		rasterizerInfo.rasterizerDiscardEnable(rasterizer.discardEnable());
		rasterizerInfo.polygonMode(rasterizer.polygonMode().value());
		rasterizerInfo.lineWidth(rasterizer.lineWidth());
		rasterizerInfo.cullMode(rasterizer.cullMode().value());
		rasterizerInfo.frontFace(rasterizer.frontFace().value());
		rasterizerInfo.depthBiasEnable(rasterizer.depthBiasEnable());
		rasterizerInfo.depthBiasConstantFactor(0.0f);
		rasterizerInfo.depthClampEnable(rasterizer.depthClampEnable());
		rasterizerInfo.depthBiasClamp(0.0f);
		rasterizerInfo.depthBiasSlopeFactor(0.0f);

		rasterizerInfo.pNext(VK_NULL_HANDLE);
		rasterizerInfo.flags(0);

		return rasterizerInfo;
	}
}
