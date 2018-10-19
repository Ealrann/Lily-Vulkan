package org.sheepy.vulkan.pipeline.graphic.render.impl;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;
import org.sheepy.vulkan.model.GraphicConfiguration;
import org.sheepy.vulkan.pipeline.graphic.render.IRasterizer;

public class BasicRasterizer implements IRasterizer
{
	private VkPipelineRasterizationStateCreateInfo rasterizerInfo;

	@Override
	public VkPipelineRasterizationStateCreateInfo allocCreateInfo(GraphicConfiguration configuration)
	{
		rasterizerInfo = VkPipelineRasterizationStateCreateInfo.calloc();
		rasterizerInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
		rasterizerInfo.depthClampEnable(false);
		rasterizerInfo.rasterizerDiscardEnable(false);
		rasterizerInfo.polygonMode(VK_POLYGON_MODE_FILL);
		rasterizerInfo.lineWidth(1f);
		rasterizerInfo.cullMode(configuration.getRasterizerCullMode().getValue());
		rasterizerInfo.frontFace(configuration.getRasterizerFrontFace().getValue());
		rasterizerInfo.depthBiasEnable(false);
		rasterizerInfo.depthBiasConstantFactor(0.0f); // Optional
		rasterizerInfo.depthBiasClamp(0.0f); // Optional
		rasterizerInfo.depthBiasSlopeFactor(0.0f); // Optional

		return rasterizerInfo;
	}

	@Override
	public void freeRasterizationStateCreateInfo()
	{
		rasterizerInfo.free();
	}

	@Override
	public void free()
	{}
}
