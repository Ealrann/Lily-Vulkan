package org.sheepy.lily.game.vulkan.pipeline.impl;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;
import org.sheepy.lily.game.vulkan.pipeline.IRasterizer;
import org.sheepy.lily.game.vulkan.swappipeline.SwapConfiguration;

public class BasicRasterizer implements IRasterizer
{
	private SwapConfiguration configuration;
	
	private VkPipelineRasterizationStateCreateInfo rasterizer;

	public BasicRasterizer( SwapConfiguration configuration)
	{
		this.configuration = configuration;
	}
	
	@Override
	public VkPipelineRasterizationStateCreateInfo allocRasterizationStateCreateInfo()
	{
		rasterizer = VkPipelineRasterizationStateCreateInfo
				.calloc();
		rasterizer.sType(VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
		rasterizer.depthClampEnable(false);
		rasterizer.rasterizerDiscardEnable(false);
		rasterizer.polygonMode(VK_POLYGON_MODE_FILL);
		rasterizer.lineWidth(1f);
		rasterizer.cullMode(configuration.rasterizerCullMode);
		rasterizer.frontFace(configuration.rasterizerFrontFace);
		rasterizer.depthBiasEnable(false);
		rasterizer.depthBiasConstantFactor(0.0f); // Optional
		rasterizer.depthBiasClamp(0.0f); // Optional
		rasterizer.depthBiasSlopeFactor(0.0f); // Optional
		
		return rasterizer;
	}

	@Override
	public void freeRasterizationStateCreateInfo()
	{
		rasterizer.free();
	}

	@Override
	public void free()
	{
	}
}
