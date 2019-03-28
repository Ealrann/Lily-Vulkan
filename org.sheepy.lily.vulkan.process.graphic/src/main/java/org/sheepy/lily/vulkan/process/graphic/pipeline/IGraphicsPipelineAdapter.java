package org.sheepy.lily.vulkan.process.graphic.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicState;
import org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.InputAssembly;
import org.sheepy.lily.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.lily.vulkan.model.process.graphic.ViewportState;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.process.graphic.api.IGraphicContext;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.ColorBlendBuilder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.DepthStencilBuilder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.DynamicStateBuilder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.InputAssemblyBuilder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.MultisampleBuilder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.RasterizerBuilder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.ShaderStageBuilder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.ViewportStateBuilder;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.lily.vulkan.resource.indexed.IVertexBufferDescriptor;

public abstract class IGraphicsPipelineAdapter extends AbstractPipelineAdapter
{
	private ShaderStageBuilder shaderStageBuilder;
	private InputAssemblyBuilder inputAssemblyBuilder;
	private ViewportStateBuilder viewportStateBuilder;
	private RasterizerBuilder rasterizerBuilder;
	private DepthStencilBuilder depthStencilBuidler;
	private MultisampleBuilder multisampleBuilder;
	private ColorBlendBuilder colorBlendBuilder;
	private DynamicStateBuilder dynamicStateBuilder;

	private IVertexBufferDescriptor<?> vertexInputState = null;

	protected long pipelineId = -1;

	public IGraphicsPipelineAdapter(IGraphicsPipeline pipeline)
	{
		super(pipeline);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		createBuilders();

		final var graphicContext = (IGraphicContext) context;
		final var device = graphicContext.getVkDevice();
		final var surfaceManager = graphicContext.getSurfaceManager();
		final var framebuffers = graphicContext.getFramebufferManager();
		final var renderPass = graphicContext.getRenderPass();

		final boolean useDepthBuffer = framebuffers.hasDepthAttachment();

		allocationDependencies.add(renderPass);

		vertexInputState = getVertexBufferDescriptor();

		final var rasterizer = getRasterizer();
		final var inputAssembly = getInputAssembly();
		final var viewportState = getViewportState();
		final var colorBlend = getColorBlend();

		// Create Pipeline
		// -----------------------
		final var pipelineInfo = VkGraphicsPipelineCreateInfo.callocStack(1, stack);
		pipelineInfo.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		pipelineInfo.pStages(shaderStageBuilder.allocShaderStageInfo(stack, getShaders()));
		pipelineInfo.pVertexInputState(vertexInputState.allocCreateInfo(stack));

		pipelineInfo
				.pInputAssemblyState(inputAssemblyBuilder.allocCreateInfo(stack, inputAssembly));
		pipelineInfo.subpass(getSubpass());

		final var viewportInfo = viewportStateBuilder.allocCreateInfo(stack, surfaceManager,
				viewportState);
		pipelineInfo.pViewportState(viewportInfo);

		pipelineInfo.pRasterizationState(rasterizerBuilder.allocCreateInfo(stack, rasterizer));

		pipelineInfo.pMultisampleState(multisampleBuilder.allocCreateInfo(stack));
		if (useDepthBuffer == true)
			pipelineInfo.pDepthStencilState(depthStencilBuidler.allocCreateInfo(stack));

		pipelineInfo.pColorBlendState(colorBlendBuilder.allocCreateInfo(stack, colorBlend));

		final var dynamicState = getDynamicState();
		if (dynamicState != null)
		{
			pipelineInfo.pDynamicState(dynamicStateBuilder.allocCreateInfo(stack, dynamicState));
		}

		pipelineInfo.layout(pipelineLayout);
		pipelineInfo.renderPass(renderPass.getAddress());
		pipelineInfo.subpass(getSubpass());
		pipelineInfo.basePipelineHandle(VK_NULL_HANDLE); // Optional
		pipelineInfo.basePipelineIndex(-1); // Optional

		final long[] aId = new long[1];
		Logger.check("Failed to create graphics pipeline!",
				() -> vkCreateGraphicsPipelines(device, VK_NULL_HANDLE, pipelineInfo, null, aId));
		pipelineId = aId[0];
	}

	private void createBuilders()
	{
		shaderStageBuilder = new ShaderStageBuilder();
		inputAssemblyBuilder = new InputAssemblyBuilder();
		viewportStateBuilder = new ViewportStateBuilder();
		rasterizerBuilder = new RasterizerBuilder();
		depthStencilBuidler = new DepthStencilBuilder();
		multisampleBuilder = new MultisampleBuilder();
		colorBlendBuilder = new ColorBlendBuilder();
		dynamicStateBuilder = new DynamicStateBuilder();
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		final var device = graphicContext.getVkDevice();
		vertexInputState.free();

		allocationDependencies.remove(graphicContext.getRenderPass());

		vkDestroyPipeline(device, pipelineId, null);
		pipelineId = -1;

		super.free(context);
	}

	protected abstract List<Shader> getShaders();

	protected abstract ViewportState getViewportState();

	protected abstract Rasterizer getRasterizer();

	protected abstract InputAssembly getInputAssembly();

	protected abstract ColorBlend getColorBlend();

	protected abstract DynamicState getDynamicState();

	public abstract int getSubpass();

	abstract protected IVertexBufferDescriptor<?> getVertexBufferDescriptor();
}
