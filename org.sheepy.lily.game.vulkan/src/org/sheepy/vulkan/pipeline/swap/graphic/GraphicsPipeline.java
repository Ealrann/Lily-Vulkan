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
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicColorBlendState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicDepthStencilState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicInputAssembly;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicMultisampleState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicRasterizer;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicShaderStage;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicViewportState;
import org.sheepy.vulkan.shader.Shader;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public class GraphicsPipeline implements IGraphicsPipeline
{
	private LogicalDevice logicalDevice;
	private List<Shader> shaders;
	private DescriptorPool descriptorPool;

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

	public GraphicsPipeline(LogicalDevice logicalDevice, SwapConfiguration configuration,
			List<Shader> shaders,
			DescriptorPool descriptorPool)
	{
		this.logicalDevice = logicalDevice;
		this.shaders = new ArrayList<>(shaders);
		this.descriptorPool = descriptorPool;

		vertexInputState = configuration.getVertexInputState();

		rasterizer = new BasicRasterizer(configuration);

		if (configuration.depthBuffer == true)
		{
			depthStencilState = new BasicDepthStencilState();
		}
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

	@Override
	public long getId()
	{
		return graphicsPipeline;
	}

	public void setShaderStage(IShaderStage shaderStage)
	{
		this.shaderStage = shaderStage;
	}

	@Override
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

	@Override
	public long getLayoutId()
	{
		return pipelineLayout;
	}
}
