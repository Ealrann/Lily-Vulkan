package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;
import org.sheepy.lily.vulkan.model.process.graphic.Rasterizer;

public class RasterizerBuilder
{
	private VkPipelineRasterizationStateCreateInfo rasterizerInfo;

	public VkPipelineRasterizationStateCreateInfo allocCreateInfo(Rasterizer rasterizer)
	{
		rasterizerInfo = VkPipelineRasterizationStateCreateInfo.calloc();
		rasterizerInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
		rasterizerInfo.depthClampEnable(rasterizer.isDepthClampEnable());
		rasterizerInfo.rasterizerDiscardEnable(rasterizer.isDiscardEnable());
		rasterizerInfo.polygonMode(rasterizer.getPolygonMode().getValue());
		rasterizerInfo.lineWidth(rasterizer.getLineWidth());
		rasterizerInfo.cullMode(rasterizer.getCullMode().getValue());
		rasterizerInfo.frontFace(rasterizer.getFrontFace().getValue());
		rasterizerInfo.depthBiasEnable(rasterizer.isDepthBiasEnable());
		rasterizerInfo.depthBiasConstantFactor(0.0f); // Optional
		rasterizerInfo.depthBiasClamp(0.0f); // Optional
		rasterizerInfo.depthBiasSlopeFactor(0.0f); // Optional

		return rasterizerInfo;
	}

	public void freeRasterizationStateCreateInfo()
	{
		rasterizerInfo.free();
	}
}
