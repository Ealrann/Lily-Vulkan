package org.sheepy.lily.vulkan.process.graphic.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;
import org.sheepy.vulkan.pipeline.IConstantsFiller;
import org.sheepy.vulkan.pipeline.IShaderStageFiller;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.builder.ColorBlendBuilder;
import org.sheepy.vulkan.pipeline.builder.DepthStencilBuilder;
import org.sheepy.vulkan.pipeline.builder.DynamicStateBuilder;
import org.sheepy.vulkan.pipeline.builder.InputAssemblyBuilder;
import org.sheepy.vulkan.pipeline.builder.MultisampleBuilder;
import org.sheepy.vulkan.pipeline.builder.RasterizerBuilder;
import org.sheepy.vulkan.pipeline.builder.ShaderStageBuilder;
import org.sheepy.vulkan.pipeline.builder.ViewportStateBuilder;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;

public class VkGraphicsPipeline extends VkPipeline
{
	private final ShaderStageBuilder shaderStageBuilder;
	private final InputAssemblyBuilder inputAssemblyBuilder;
	private final ViewportStateBuilder viewportStateBuilder;
	private final RasterizerBuilder rasterizerBuilder;
	private final DepthStencilBuilder depthStencilBuidler;
	private final MultisampleBuilder multisampleBuilder;
	private final ColorBlendBuilder colorBlendBuilder;
	private final DynamicStateBuilder dynamicStateBuilder;

	private final ColorBlend colorBlend;
	private final Rasterizer rasterizer;
	private final InputAssembly inputAssembly;
	private final ViewportState viewportState;
	private final DynamicState dynamicState;
	private final IVertexBufferDescriptor<?> vertexInputState;
	private final List<IShaderStageFiller> shaders;

	protected long pipelineId = -1;
	private final int subpass;

	public VkGraphicsPipeline(	List<IVkDescriptorSet> descriptorSets,
								List<IConstantsFiller> constants,
								ColorBlend colorBlend,
								Rasterizer rasterizer,
								InputAssembly inputAssembly,
								ViewportState viewportState,
								DynamicState dynamicState,
								IVertexBufferDescriptor<?> vertexBufferDescriptor,
								List<IShaderStageFiller> shaders,
								int subpass)
	{
		super(descriptorSets, constants);

		this.colorBlend = colorBlend;
		this.rasterizer = rasterizer;
		this.inputAssembly = inputAssembly;
		this.viewportState = viewportState;
		this.dynamicState = dynamicState;
		this.vertexInputState = vertexBufferDescriptor;
		this.shaders = shaders;
		this.subpass = subpass;

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
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);
		final var graphicContext = (IGraphicContext) context;
		final var device = graphicContext.getVkDevice();
		final var surfaceManager = graphicContext.getSurfaceManager();
		final var framebuffers = graphicContext.getFramebufferManager();
		final var renderPass = graphicContext.getRenderPass();
		final var extent = surfaceManager.getExtent();

		final boolean useDepthBuffer = framebuffers.hasDepthAttachment();

		// Create Pipeline
		// -----------------------
		final var info = VkGraphicsPipelineCreateInfo.callocStack(1, stack);
		info.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		info.pStages(shaderStageBuilder.allocShaderStageInfo(stack, shaders));
		info.pVertexInputState(vertexInputState.allocCreateInfo(stack));
		info.pInputAssemblyState(inputAssemblyBuilder.allocCreateInfo(stack, inputAssembly));
		info.pViewportState(viewportStateBuilder.allocCreateInfo(stack, extent, viewportState));
		info.pRasterizationState(rasterizerBuilder.allocCreateInfo(stack, rasterizer));
		info.pMultisampleState(multisampleBuilder.allocCreateInfo(stack));
		if (useDepthBuffer == true)
			info.pDepthStencilState(depthStencilBuidler.allocCreateInfo(stack));
		info.pColorBlendState(colorBlendBuilder.allocCreateInfo(stack, colorBlend));
		if (dynamicState != null)
			info.pDynamicState(dynamicStateBuilder.allocCreateInfo(stack, dynamicState));

		info.layout(pipelineLayout);
		info.renderPass(renderPass.getAddress());
		info.subpass(subpass);
		info.basePipelineHandle(VK_NULL_HANDLE);
		info.basePipelineIndex(-1);

		final long[] aId = new long[1];
		Logger.check("Failed to create graphics pipeline!",
				() -> vkCreateGraphicsPipelines(device, VK_NULL_HANDLE, info, null, aId));
		pipelineId = aId[0];
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		final var device = graphicContext.getVkDevice();
		vertexInputState.free();

		vkDestroyPipeline(device, pipelineId, null);
		pipelineId = -1;
		super.free(context);
	}

	@Override
	public long getPipelineId()
	{
		return pipelineId;
	}
}
