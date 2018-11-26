package org.sheepy.vulkan.process.graphic.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.vulkan.process.graphic.pipeline.builder.ColorBlendBuilder;
import org.sheepy.vulkan.process.graphic.pipeline.builder.DepthStencilBuilder;
import org.sheepy.vulkan.process.graphic.pipeline.builder.InputAssemblyBuilder;
import org.sheepy.vulkan.process.graphic.pipeline.builder.MultisampleBuilder;
import org.sheepy.vulkan.process.graphic.pipeline.builder.RasterizerBuilder;
import org.sheepy.vulkan.process.graphic.pipeline.builder.ShaderStageBuilder;
import org.sheepy.vulkan.process.graphic.pipeline.builder.ViewportStateBuilder;
import org.sheepy.vulkan.process.graphic.pool.IGraphicContextAdapter;
import org.sheepy.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;

public abstract class GraphicsPipelineAdapter extends AbstractPipelineAdapter<GraphicCommandBuffer>
		implements IGraphicPipelineAdapter
{
	private final ShaderStageBuilder shaderStageBuilder = new ShaderStageBuilder();
	private final InputAssemblyBuilder inputAssemblyBuilder = new InputAssemblyBuilder();
	private final ViewportStateBuilder viewportStateBuilder = new ViewportStateBuilder();
	private final RasterizerBuilder rasterizerBuilder = new RasterizerBuilder();
	private final DepthStencilBuilder depthStencilBuidler = new DepthStencilBuilder();
	private final MultisampleBuilder multisampleBuilder = new MultisampleBuilder();
	private final ColorBlendBuilder colorBlendBuilder = new ColorBlendBuilder();

	public IVertexBufferDescriptor<?> vertexInputState = null;

	protected long id = -1;

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		super.deepAllocate(stack);

		final var context = IGraphicContextAdapter.adapt(target).getGraphicContext(target);
		final var useDepthBuffer = context.graphicProcessPool.getDepthImage() != null;
		final var device = context.getVkDevice();
		final GraphicsPipeline pipeline = (GraphicsPipeline) target;
		var swapchain = context.swapChainManager;

		vertexInputState = getVertexBufferDescriptor();

		// Create Pipeline
		// -----------------------
		final var pipelineInfo = VkGraphicsPipelineCreateInfo.callocStack(1, stack);
		pipelineInfo.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		pipelineInfo.pStages(shaderStageBuilder.allocShaderStageInfo(pipeline.getShaders()));
		pipelineInfo.pVertexInputState(vertexInputState.allocCreateInfo());
		pipelineInfo.pInputAssemblyState(inputAssemblyBuilder.allocCreateInfo());

		var viewportState = pipeline.getViewportState();
		if (viewportState != null)
		{
			var allocCreateInfo = viewportStateBuilder.allocCreateInfo(swapchain, viewportState);
			pipelineInfo.pViewportState(allocCreateInfo);
		}

		var rasterizer = pipeline.getRasterizer();
		if (rasterizer != null)
		{
			pipelineInfo.pRasterizationState(rasterizerBuilder.allocCreateInfo(rasterizer));
		}

		pipelineInfo.pMultisampleState(multisampleBuilder.allocCreateInfo());
		if (useDepthBuffer == true)
			pipelineInfo.pDepthStencilState(depthStencilBuidler.allocCreateInfo());

		var colorBlend = pipeline.getColorBlend();
		if (colorBlend != null)
		{
			pipelineInfo.pColorBlendState(colorBlendBuilder.allocCreateInfo(colorBlend));
		}
		// pipelineInfo.pDynamicState(dynamicState.allocDynamicStateCreateInfo());
		pipelineInfo.layout(pipelineLayout);
		pipelineInfo.renderPass(context.renderPass.getId());
		pipelineInfo.subpass(0);
		pipelineInfo.basePipelineHandle(VK_NULL_HANDLE); // Optional
		pipelineInfo.basePipelineIndex(-1); // Optional

		final long[] aId = new long[1];
		Logger.check("Failed to create graphics pipeline!",
				() -> vkCreateGraphicsPipelines(device, VK_NULL_HANDLE, pipelineInfo, null, aId));
		id = aId[0];

		// dynamicState.freeDynamicStateCreateInfo();
		colorBlendBuilder.freeColorBlendStateCreateInfo();
		multisampleBuilder.freeMultisampleStateCreateInfo();
		rasterizerBuilder.freeRasterizationStateCreateInfo();
		viewportStateBuilder.freeViewportStateCreateInfo();
		inputAssemblyBuilder.freeInputAssemblyStateCreateInfo();
		vertexInputState.freeInputStateCreateInfo();
		shaderStageBuilder.freeShaderStageInfo();
		if (useDepthBuffer == true) depthStencilBuidler.freeDepthStencilStateCreateInfo();
	}

	@Override
	public boolean isDirty()
	{
		final var context = IGraphicContextAdapter.adapt(target).getGraphicContext(target);
		return context.renderPass.isDirty();
	}

	@Override
	public void free()
	{
		// dynamicState.free();
		vertexInputState.free();

		super.free();
	}

	abstract protected IVertexBufferDescriptor<?> getVertexBufferDescriptor();
}
