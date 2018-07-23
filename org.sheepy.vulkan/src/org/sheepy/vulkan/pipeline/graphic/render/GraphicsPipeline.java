package org.sheepy.vulkan.pipeline.graphic.render;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.DescriptorSet;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.descriptor.IDescriptorSetConfiguration;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.AbstractPipeline;
import org.sheepy.vulkan.pipeline.IPipelineExecutable;
import org.sheepy.vulkan.pipeline.PipelineId;
import org.sheepy.vulkan.pipeline.graphic.GraphicContext;
import org.sheepy.vulkan.pipeline.graphic.IGraphicProcessUnit;

public abstract class GraphicsPipeline extends AbstractPipeline
		implements IGraphicProcessUnit, IDescriptorSetConfiguration, IAllocable
{
	private GraphicContext context;
	private DescriptorPool descriptorPool;
	protected final GraphicPipelineConfiguration pipelineConfiguration;

	public GraphicsPipeline(LogicalDevice logicalDevice,
			GraphicPipelineConfiguration pipelineConfiguration)
	{
		super(logicalDevice);
		this.pipelineConfiguration = pipelineConfiguration;

		addPipelineUnit(pipelineConfiguration);
	}

	@Override
	public void bindContext(GraphicContext context, DescriptorPool descriptorPool)
	{
		this.context = context;
		this.descriptorPool = descriptorPool;
	}

	@Override
	protected long allocatePipelineLayout(MemoryStack stack)
	{
		// Create Pipeline Layout
		// -----------------------
		VkPipelineLayoutCreateInfo pipelineLayoutInfo = VkPipelineLayoutCreateInfo
				.callocStack(stack);
		pipelineLayoutInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		if (descriptorPool != null && descriptorPool.size() > 0)
		{
			pipelineLayoutInfo.pSetLayouts(descriptorPool.allocLayoutBuffer());
		}
		pipelineLayoutInfo.pPushConstantRanges(null); // Optional

		long[] aPipelineLayout = new long[1];
		if (vkCreatePipelineLayout(pipelineConfiguration.getVkDevice(), pipelineLayoutInfo, null,
				aPipelineLayout) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create pipeline layout!");
		}
		return aPipelineLayout[0];
	}

	@Override
	protected List<IPipelineExecutable> allocatePipeline(MemoryStack stack)
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

	@Override
	public void executePreRender(RenderCommandBuffer commandBuffer)
	{}

	@Override
	public void executePostRender(RenderCommandBuffer commandBuffer)
	{}

	@Override
	public void execute(RenderCommandBuffer commandBuffer)
	{
		LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(1);

		if (descriptorPool != null && descriptorPool.size() > 0)
		{
			DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(this);

			bDescriptorSet.put(descriptorSet.getId());
			bDescriptorSet.flip();

			long pipelineLayout = getLayoutId();
			vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(), VK_PIPELINE_BIND_POINT_GRAPHICS, pipelineLayout,
					0, bDescriptorSet, null);
		}

		List<IPipelineExecutable> executables = getExecutables();
		for (int i = 0; i < executables.size(); i++)
		{
			IPipelineExecutable executable = executables.get(i);

			executable.execute(commandBuffer.getVkCommandBuffer());
		}

		setDirty(false);

		MemoryUtil.memFree(bDescriptorSet);
	}

	@Override
	public List<IDescriptor> getDescriptors()
	{
		return pipelineConfiguration.descriptors;
	}

	protected abstract PipelineId buildGraphicPipeline(long id);
}
