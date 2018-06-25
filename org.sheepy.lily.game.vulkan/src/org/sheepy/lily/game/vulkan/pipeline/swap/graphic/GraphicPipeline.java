package org.sheepy.lily.game.vulkan.pipeline.swap.graphic;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.swap.IRenderPass;
import org.sheepy.lily.game.vulkan.pipeline.swap.SwapConfiguration;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.graphic.impl.BasicColorBlendState;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.graphic.impl.BasicDepthStencilState;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.graphic.impl.BasicInputAssembly;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.graphic.impl.BasicMultisampleState;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.graphic.impl.BasicRasterizer;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.graphic.impl.BasicShaderStage;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.graphic.impl.BasicViewportState;
import org.sheepy.lily.game.vulkan.shader.Shader;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public class GraphicPipeline
{
	private LogicalDevice logicalDevice;

	private IShaderStage shaderStage = new BasicShaderStage();
	private IVertexDescriptor<?> vertexInputState;
	private IInputAssembly inputAssembly = new BasicInputAssembly();
	private IViewportState viewportState = new BasicViewportState();
	private IRasterizer rasterizer;
	private IDepthStencilState depthStencilState = null;
	private IMultisampleState multisampleState = new BasicMultisampleState();
	private IColorBlendState colorBlendState = new BasicColorBlendState();
	// private IDynamicState dynamicState;

	private long graphicsPipeline = -1;
	private long pipelineLayout = 1;

	public GraphicPipeline(LogicalDevice logicalDevice, SwapConfiguration configuration)
	{
		this.logicalDevice = logicalDevice;

		vertexInputState = configuration.getVertexInputState();

		rasterizer = new BasicRasterizer(configuration);

		if (configuration.depthBuffer == true)
		{
			depthStencilState = new BasicDepthStencilState();
		}
		// dynamicState = new BasicDynamicState();
	}

	public void load(SwapChainManager swapChainManager,
			List<Shader> shaders,
			IRenderPass renderPass,
			DescriptorPool descriptorPool)
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
		pipelineInfo.pStages(shaderStage.allocShaderStageInfo(shaders));
		pipelineInfo.pVertexInputState(vertexInputState.allocInputStateCreateInfo());
		pipelineInfo.pInputAssemblyState(inputAssembly.allocInputAssemblyStateCreateInfo());
		pipelineInfo.pViewportState(viewportState.allocViewportStateCreateInfo(swapChainManager));
		pipelineInfo.pRasterizationState(rasterizer.allocRasterizationStateCreateInfo());
		pipelineInfo.pMultisampleState(multisampleState.allocMultisampleStateCreateInfo());
		if (depthStencilState != null)
			pipelineInfo.pDepthStencilState(depthStencilState.allocDepthStencilStateCreateInfo());
		pipelineInfo.pColorBlendState(colorBlendState.allocColorBlendStateCreateInfo());
		// pipelineInfo.pDynamicState(dynamicState.allocDynamicStateCreateInfo());
		pipelineInfo.layout(pipelineLayout);
		pipelineInfo.renderPass(renderPass.getID());
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
		colorBlendState.freeColorBlendStateCreateInfo();
		multisampleState.freeMultisampleStateCreateInfo();
		rasterizer.freeRasterizationStateCreateInfo();
		viewportState.freeViewportStateCreateInfo();
		inputAssembly.freeInputAssemblyStateCreateInfo();
		vertexInputState.freeInputStateCreateInfo();
		shaderStage.freeShaderStageInfo();

		pipelineLayoutInfo.free();
		pipelineInfo.free();
	}

	public long getId()
	{
		return graphicsPipeline;
	}

	public void setShaderStage(IShaderStage shaderStage)
	{
		this.shaderStage = shaderStage;
	}

	public void free()
	{
		// dynamicState.free();
		colorBlendState.free();
		if (depthStencilState != null) depthStencilState.free();
		multisampleState.free();
		rasterizer.free();
		viewportState.free();
		inputAssembly.free();
		vertexInputState.free();
		shaderStage.free();

		vkDestroyPipeline(logicalDevice.getVkDevice(), graphicsPipeline, null);
		vkDestroyPipelineLayout(logicalDevice.getVkDevice(), pipelineLayout, null);

		graphicsPipeline = -1;
		pipelineLayout = -1;
	}

	public long getLayoutId()
	{
		return pipelineLayout;
	}
}
