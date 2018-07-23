package org.sheepy.vulkan.pipeline.graphic.render;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.vulkan.pipeline.graphic.IGraphicsPipeline;

public class GraphicsPipeline implements IGraphicsPipeline
{
	private GraphicSwapConfiguration configuration;

	private long graphicsPipeline = -1;
	private long pipelineLayout = 1;

	
	public GraphicsPipeline(GraphicSwapConfiguration configuration)
	{
		this.configuration = configuration;
	}
	
	@Override
	public void allocate(MemoryStack stack)
	{
		// Create Pipeline Layout
		// -----------------------
		VkPipelineLayoutCreateInfo pipelineLayoutInfo = VkPipelineLayoutCreateInfo
				.callocStack(stack);
		pipelineLayoutInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		if (configuration.descriptorPool != null)
		{
			pipelineLayoutInfo.pSetLayouts(configuration.descriptorPool.allocLayoutBuffer());
		}
		pipelineLayoutInfo.pPushConstantRanges(null); // Optional

		long[] aPipelineLayout = new long[1];
		if (vkCreatePipelineLayout(configuration.getVkDevice(), pipelineLayoutInfo, null,
				aPipelineLayout) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create pipeline layout!");
		}
		pipelineLayout = aPipelineLayout[0];

		// Create Pipeline
		// -----------------------
		VkGraphicsPipelineCreateInfo.Buffer pipelineInfo = VkGraphicsPipelineCreateInfo
				.callocStack(1, stack);
		pipelineInfo.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		pipelineInfo
				.pStages(configuration.shaderStage.allocShaderStageInfo(configuration.shaders));
		pipelineInfo.pVertexInputState(configuration.vertexInputState.allocInputStateCreateInfo());
		pipelineInfo.pInputAssemblyState(
				configuration.inputAssembly.allocInputAssemblyStateCreateInfo());
		pipelineInfo.pViewportState(
				configuration.viewportState.allocViewportStateCreateInfo(configuration.swapChainManager));
		pipelineInfo
				.pRasterizationState(configuration.rasterizer.allocRasterizationStateCreateInfo());
		pipelineInfo.pMultisampleState(
				configuration.multisampleState.allocMultisampleStateCreateInfo());
		if (configuration.depthBuffer == true) pipelineInfo.pDepthStencilState(
				configuration.depthStencilState.allocDepthStencilStateCreateInfo());
		pipelineInfo
				.pColorBlendState(configuration.colorBlendState.allocColorBlendStateCreateInfo());
		// pipelineInfo.pDynamicState(dynamicState.allocDynamicStateCreateInfo());
		pipelineInfo.layout(pipelineLayout);
		pipelineInfo.renderPass(configuration.renderPass.getId());
		pipelineInfo.subpass(0);
		pipelineInfo.basePipelineHandle(VK_NULL_HANDLE); // Optional
		pipelineInfo.basePipelineIndex(-1); // Optional

		long[] aGraphicsPipeline = new long[1];
		if (vkCreateGraphicsPipelines(configuration.getVkDevice(), VK_NULL_HANDLE, pipelineInfo,
				null, aGraphicsPipeline) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create graphics pipeline!");
		}
		graphicsPipeline = aGraphicsPipeline[0];

		// dynamicState.freeDynamicStateCreateInfo();
		configuration.colorBlendState.freeColorBlendStateCreateInfo();
		configuration.multisampleState.freeMultisampleStateCreateInfo();
		configuration.rasterizer.freeRasterizationStateCreateInfo();
		configuration.viewportState.freeViewportStateCreateInfo();
		configuration.inputAssembly.freeInputAssemblyStateCreateInfo();
		configuration.vertexInputState.freeInputStateCreateInfo();
		configuration.shaderStage.freeShaderStageInfo();
		if (configuration.depthBuffer == true)
			configuration.depthStencilState.freeDepthStencilStateCreateInfo();
	}

	@Override
	public long getId()
	{
		return graphicsPipeline;
	}

	@Override
	public void free()
	{
		// dynamicState.free();
		configuration.colorBlendState.free();
		if (configuration.depthBuffer == true) configuration.depthStencilState.free();
		configuration.multisampleState.free();
		configuration.rasterizer.free();
		configuration.viewportState.free();
		configuration.inputAssembly.free();
		configuration.vertexInputState.free();
		configuration.shaderStage.free();

		vkDestroyPipeline(configuration.getVkDevice(), graphicsPipeline, null);
		vkDestroyPipelineLayout(configuration.getVkDevice(), pipelineLayout, null);

		graphicsPipeline = -1;
		pipelineLayout = -1;
	}

	@Override
	public long getLayoutId()
	{
		return pipelineLayout;
	}
}
