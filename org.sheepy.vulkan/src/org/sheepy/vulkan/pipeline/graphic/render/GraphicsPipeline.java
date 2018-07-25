package org.sheepy.vulkan.pipeline.graphic.render;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.pipeline.AbstractPipeline;
import org.sheepy.vulkan.pipeline.IProcessUnit;
import org.sheepy.vulkan.pipeline.graphic.GraphicContext;
import org.sheepy.vulkan.pipeline.graphic.IGraphicProcessUnit;

public abstract class GraphicsPipeline extends AbstractPipeline implements IGraphicProcessUnit
{
	protected final GraphicPipelineConfiguration pipelineConfiguration;
	protected GraphicContext context;

	public GraphicsPipeline(GraphicPipelineConfiguration pipelineConfiguration)
	{
		super(pipelineConfiguration.descriptors);

		this.pipelineConfiguration = pipelineConfiguration;

		addPipelineUnit(pipelineConfiguration);
	}

	@Override
	public void bindContext(DescriptorPool descriptorPool, GraphicContext context)
	{
		super.bindContext(context.logicalDevice, descriptorPool);
		this.context = context;
	}

	@Override
	protected List<IProcessUnit> allocatePipeline(MemoryStack stack)
	{
		// Create Pipeline
		// -----------------------
		VkGraphicsPipelineCreateInfo.Buffer pipelineInfo = VkGraphicsPipelineCreateInfo
				.callocStack(1, stack);
		pipelineInfo.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		pipelineInfo.pStages(pipelineConfiguration.shaderStage
				.allocShaderStageInfo(pipelineConfiguration.shaders));
		pipelineInfo.pVertexInputState(
				pipelineConfiguration.vertexInputState.allocInputStateCreateInfo());
		pipelineInfo.pInputAssemblyState(
				pipelineConfiguration.inputAssembly.allocInputAssemblyStateCreateInfo());
		pipelineInfo.pViewportState(pipelineConfiguration.viewportState
				.allocViewportStateCreateInfo(context.swapChainManager));
		pipelineInfo.pRasterizationState(
				pipelineConfiguration.rasterizer.allocRasterizationStateCreateInfo());
		pipelineInfo.pMultisampleState(
				pipelineConfiguration.multisampleState.allocMultisampleStateCreateInfo());
		if (context.configuration.depthBuffer == true) pipelineInfo.pDepthStencilState(
				pipelineConfiguration.depthStencilState.allocDepthStencilStateCreateInfo());
		pipelineInfo.pColorBlendState(
				pipelineConfiguration.colorBlendState.allocColorBlendStateCreateInfo());
		// pipelineInfo.pDynamicState(dynamicState.allocDynamicStateCreateInfo());
		pipelineInfo.layout(pipelineLayout);
		pipelineInfo.renderPass(context.renderPass.getId());
		pipelineInfo.subpass(0);
		pipelineInfo.basePipelineHandle(VK_NULL_HANDLE); // Optional
		pipelineInfo.basePipelineIndex(-1); // Optional

		long[] aGraphicsPipeline = new long[1];
		if (vkCreateGraphicsPipelines(pipelineConfiguration.getVkDevice(), VK_NULL_HANDLE,
				pipelineInfo, null, aGraphicsPipeline) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create graphics pipeline!");
		}

		// dynamicState.freeDynamicStateCreateInfo();
		pipelineConfiguration.colorBlendState.freeColorBlendStateCreateInfo();
		pipelineConfiguration.multisampleState.freeMultisampleStateCreateInfo();
		pipelineConfiguration.rasterizer.freeRasterizationStateCreateInfo();
		pipelineConfiguration.viewportState.freeViewportStateCreateInfo();
		pipelineConfiguration.inputAssembly.freeInputAssemblyStateCreateInfo();
		pipelineConfiguration.vertexInputState.freeInputStateCreateInfo();
		pipelineConfiguration.shaderStage.freeShaderStageInfo();
		if (context.configuration.depthBuffer == true)
			pipelineConfiguration.depthStencilState.freeDepthStencilStateCreateInfo();

		return Collections.singletonList(buildGraphicPipeline(aGraphicsPipeline[0]));
	}

	@Override
	public void free()
	{
		// dynamicState.free();
		pipelineConfiguration.colorBlendState.free();
		if (context.configuration.depthBuffer == true)
			pipelineConfiguration.depthStencilState.free();
		pipelineConfiguration.multisampleState.free();
		pipelineConfiguration.rasterizer.free();
		pipelineConfiguration.viewportState.free();
		pipelineConfiguration.inputAssembly.free();
		pipelineConfiguration.vertexInputState.free();
		pipelineConfiguration.shaderStage.free();

		super.free();
	}

	protected abstract GraphicPipelineId buildGraphicPipeline(long id);

}
