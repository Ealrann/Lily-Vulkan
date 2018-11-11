package org.sheepy.vulkan.process.graphic.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.vulkan.process.graphic.pipeline.render.IColorBlendState;
import org.sheepy.vulkan.process.graphic.pipeline.render.IDepthStencilState;
import org.sheepy.vulkan.process.graphic.pipeline.render.IInputAssembly;
import org.sheepy.vulkan.process.graphic.pipeline.render.IMultisampleState;
import org.sheepy.vulkan.process.graphic.pipeline.render.IRasterizer;
import org.sheepy.vulkan.process.graphic.pipeline.render.IShaderStage;
import org.sheepy.vulkan.process.graphic.pipeline.render.IViewportState;
import org.sheepy.vulkan.process.graphic.pipeline.render.impl.BasicColorBlendState;
import org.sheepy.vulkan.process.graphic.pipeline.render.impl.BasicDepthStencilState;
import org.sheepy.vulkan.process.graphic.pipeline.render.impl.BasicInputAssembly;
import org.sheepy.vulkan.process.graphic.pipeline.render.impl.BasicMultisampleState;
import org.sheepy.vulkan.process.graphic.pipeline.render.impl.BasicRasterizer;
import org.sheepy.vulkan.process.graphic.pipeline.render.impl.BasicShaderStage;
import org.sheepy.vulkan.process.graphic.pipeline.render.impl.BasicViewportState;
import org.sheepy.vulkan.process.graphic.pool.IGraphicContextAdapter;
import org.sheepy.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;

public abstract class GraphicsPipelineAdapter extends AbstractPipelineAdapter<GraphicCommandBuffer>
		implements IGraphicPipelineAdapter
{
	public final IShaderStage shaderStage = new BasicShaderStage();
	public final IInputAssembly inputAssembly = new BasicInputAssembly();
	public final IViewportState viewportState = new BasicViewportState();
	public final IRasterizer rasterizer = new BasicRasterizer();
	public final IDepthStencilState depthStencilState = new BasicDepthStencilState();
	public final IMultisampleState multisampleState = new BasicMultisampleState();
	public final IColorBlendState colorBlendState = new BasicColorBlendState();

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

		vertexInputState = getVertexBufferDescriptor();

		// Create Pipeline
		// -----------------------
		final var pipelineInfo = VkGraphicsPipelineCreateInfo.callocStack(1, stack);
		pipelineInfo.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		pipelineInfo.pStages(shaderStage.allocShaderStageInfo(pipeline.getShaders()));
		pipelineInfo.pVertexInputState(vertexInputState.allocCreateInfo());
		pipelineInfo.pInputAssemblyState(inputAssembly.allocCreateInfo());
		pipelineInfo.pViewportState(viewportState.allocCreateInfo(context.swapChainManager));
		pipelineInfo.pRasterizationState(rasterizer.allocCreateInfo(context.configuration));
		pipelineInfo.pMultisampleState(multisampleState.allocCreateInfo());
		if (useDepthBuffer == true)
			pipelineInfo.pDepthStencilState(depthStencilState.allocCreateInfo());
		pipelineInfo.pColorBlendState(colorBlendState.allocCreateInfo());
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
		colorBlendState.freeColorBlendStateCreateInfo();
		multisampleState.freeMultisampleStateCreateInfo();
		rasterizer.freeRasterizationStateCreateInfo();
		viewportState.freeViewportStateCreateInfo();
		inputAssembly.freeInputAssemblyStateCreateInfo();
		vertexInputState.freeInputStateCreateInfo();
		shaderStage.freeShaderStageInfo();
		if (useDepthBuffer == true) depthStencilState.freeDepthStencilStateCreateInfo();
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
		final var context = IGraphicContextAdapter.adapt(target).getGraphicContext(target);
		final boolean useDepthBuffer = context.graphicProcessPool.getDepthImage() != null;
		// dynamicState.free();
		colorBlendState.free();
		if (useDepthBuffer == true) depthStencilState.free();
		multisampleState.free();
		rasterizer.free();
		viewportState.free();
		inputAssembly.free();
		vertexInputState.free();
		shaderStage.free();

		super.free();
	}

	abstract protected IVertexBufferDescriptor<?> getVertexBufferDescriptor();
}
