package org.sheepy.vulkan.pipeline.swap.graphic;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.swap.IGraphicsPipeline;
import org.sheepy.vulkan.pipeline.swap.IRenderPass;
import org.sheepy.vulkan.pipeline.swap.SwapConfiguration;
import org.sheepy.vulkan.shader.Shader;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public class GraphicsPipeline implements IGraphicsPipeline
{
	private LogicalDevice logicalDevice;
	private SwapConfiguration configuration;
	private List<Shader> shaders;
	private DescriptorPool descriptorPool;

	private long graphicsPipeline = -1;
	private long pipelineLayout = 1;

	public GraphicsPipeline(LogicalDevice logicalDevice, SwapConfiguration configuration,
			List<Shader> shaders,
			DescriptorPool descriptorPool)
	{
		this.logicalDevice = logicalDevice;
		this.configuration = configuration;
		this.shaders = new ArrayList<>(shaders);
		this.descriptorPool = descriptorPool;


		// dynamicState = new BasicDynamicState();
	}

	@Override
	public void load(SwapChainManager swapChainManager,
			IRenderPass renderPass)
	{
		// Create Pipeline Layout
		// -----------------------
		VkPipelineLayoutCreateInfo pipelineLayoutInfo = VkPipelineLayoutCreateInfo.calloc();
		pipelineLayoutInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		if (descriptorPool != null)
		{
			pipelineLayoutInfo.pSetLayouts(descriptorPool.allocLayoutBuffer());
		}
		pipelineLayoutInfo.pPushConstantRanges(null); // Optional

		long[] aPipelineLayout = new long[1];
		if (vkCreatePipelineLayout(logicalDevice.getVkDevice(), pipelineLayoutInfo, null,
				aPipelineLayout) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create pipeline layout!");
		}
		pipelineLayout = aPipelineLayout[0];

		// Create Pipeline
		// -----------------------
		VkGraphicsPipelineCreateInfo.Buffer pipelineInfo = VkGraphicsPipelineCreateInfo.calloc(1);
		pipelineInfo.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		pipelineInfo.pStages(configuration.shaderStage.allocShaderStageInfo(shaders));
		pipelineInfo.pVertexInputState(configuration.vertexInputState.allocInputStateCreateInfo());
		pipelineInfo.pInputAssemblyState(configuration.inputAssembly.allocInputAssemblyStateCreateInfo());
		pipelineInfo.pViewportState(configuration.viewportState.allocViewportStateCreateInfo(swapChainManager));
		pipelineInfo.pRasterizationState(configuration.rasterizer.allocRasterizationStateCreateInfo());
		pipelineInfo.pMultisampleState(configuration.multisampleState.allocMultisampleStateCreateInfo());
		if (configuration.depthBuffer == true)
			pipelineInfo.pDepthStencilState(configuration.depthStencilState.allocDepthStencilStateCreateInfo());
		pipelineInfo.pColorBlendState(configuration.colorBlendState.allocColorBlendStateCreateInfo());
		// pipelineInfo.pDynamicState(dynamicState.allocDynamicStateCreateInfo());
		pipelineInfo.layout(pipelineLayout);
		pipelineInfo.renderPass(renderPass.getId());
		pipelineInfo.subpass(0);
		pipelineInfo.basePipelineHandle(VK_NULL_HANDLE); // Optional
		pipelineInfo.basePipelineIndex(-1); // Optional

		long[] aGraphicsPipeline = new long[1];
		if (vkCreateGraphicsPipelines(logicalDevice.getVkDevice(), VK_NULL_HANDLE, pipelineInfo,
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

		pipelineLayoutInfo.free();
		pipelineInfo.free();
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

		vkDestroyPipeline(logicalDevice.getVkDevice(), graphicsPipeline, null);
		vkDestroyPipelineLayout(logicalDevice.getVkDevice(), pipelineLayout, null);

		graphicsPipeline = -1;
		pipelineLayout = -1;
	}

	@Override
	public long getLayoutId()
	{
		return pipelineLayout;
	}
}
