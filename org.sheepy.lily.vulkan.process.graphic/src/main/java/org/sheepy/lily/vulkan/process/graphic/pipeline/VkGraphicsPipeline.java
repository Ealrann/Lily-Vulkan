package org.sheepy.lily.vulkan.process.graphic.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;
import org.sheepy.vulkan.pipeline.VkShaderStage;
import org.sheepy.vulkan.pipeline.builder.ColorBlendBuilder;
import org.sheepy.vulkan.pipeline.builder.DepthStencilBuilder;
import org.sheepy.vulkan.pipeline.builder.DynamicStateBuilder;
import org.sheepy.vulkan.pipeline.builder.InputAssemblyBuilder;
import org.sheepy.vulkan.pipeline.builder.MultisampleBuilder;
import org.sheepy.vulkan.pipeline.builder.RasterizerBuilder;
import org.sheepy.vulkan.pipeline.builder.ShaderStageBuilder;
import org.sheepy.vulkan.pipeline.builder.ViewportStateBuilder;
import org.sheepy.vulkan.resource.indexed.VkInputStateDescriptor;

public class VkGraphicsPipeline extends VkPipeline<IGraphicContext>
{
	private static final String FAILED_TO_CREATE_GRAPHICS_PIPELINE = "Failed to create graphics pipeline";

	private final ShaderStageBuilder shaderStageBuilder;
	private final InputAssemblyBuilder inputAssemblyBuilder;
	private final ViewportStateBuilder viewportStateBuilder;
	private final RasterizerBuilder rasterizerBuilder;
	private final DepthStencilBuilder depthStencilBuidler;
	private final MultisampleBuilder multisampleBuilder;
	private final ColorBlendBuilder colorBlendBuilder;
	private final DynamicStateBuilder dynamicStateBuilder;

	private final VkPipelineLayout<? super IGraphicContext> pipelineLayout;
	private final ColorBlend colorBlend;
	private final Rasterizer rasterizer;
	private final InputAssembly inputAssembly;
	private final ViewportState viewportState;
	private final DynamicState dynamicState;
	private final VkInputStateDescriptor vertexDescriptor;
	private final List<VkShaderStage> shaderStages;
	private final ByteBuffer specializationData;
	private final boolean depthStencil;
	private final int subpass;

	protected long pipelinePtr = 0;

	public VkGraphicsPipeline(	VkPipelineLayout<? super IGraphicContext> pipelineLayout,
								ColorBlend colorBlend,
								Rasterizer rasterizer,
								InputAssembly inputAssembly,
								ViewportState viewportState,
								DynamicState dynamicState,
								VkInputStateDescriptor vertexBufferDescriptor,
								List<VkShaderStage> shaderStages,
								ByteBuffer specializationData,
								int subpass,
								boolean depthStencil)
	{
		super(VK_PIPELINE_BIND_POINT_GRAPHICS);

		this.pipelineLayout = pipelineLayout;
		this.colorBlend = colorBlend;
		this.rasterizer = rasterizer;
		this.inputAssembly = inputAssembly;
		this.viewportState = viewportState;
		this.dynamicState = dynamicState;
		this.vertexDescriptor = vertexBufferDescriptor;
		this.shaderStages = shaderStages;
		this.specializationData = specializationData;
		this.subpass = subpass;
		this.depthStencil = depthStencil;

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
	public void allocate(IGraphicContext context)
	{
		final var device = context.getVkDevice();
		final var surfaceManager = context.getSurfaceManager();
		final var renderPass = context.getRenderPass();
		final var extent = surfaceManager.getExtent();
		final var stack = context.stack();

		// Create Pipeline
		// -----------------------
		final var info = VkGraphicsPipelineCreateInfo.callocStack(1, stack);
		info.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		info.pStages(shaderStageBuilder.allocShaderStageInfo(	stack,
																shaderStages,
																specializationData));
		info.pVertexInputState(vertexDescriptor.allocCreateInfo(stack));
		info.pInputAssemblyState(inputAssemblyBuilder.allocCreateInfo(stack, inputAssembly));
		info.pViewportState(viewportStateBuilder.allocCreateInfo(stack, extent, viewportState));
		info.pRasterizationState(rasterizerBuilder.allocCreateInfo(stack, rasterizer));
		info.pMultisampleState(multisampleBuilder.allocCreateInfo(stack));
		if (depthStencil == true)
			info.pDepthStencilState(depthStencilBuidler.allocCreateInfo(stack));
		info.pColorBlendState(colorBlendBuilder.allocCreateInfo(stack, colorBlend));
		if (dynamicState != null)
			info.pDynamicState(dynamicStateBuilder.allocCreateInfo(stack, dynamicState));

		info.layout(pipelineLayout.getId());
		info.renderPass(renderPass.getPtr());
		info.subpass(subpass);
		info.basePipelineHandle(VK_NULL_HANDLE);
		info.basePipelineIndex(-1);

		final long[] aId = new long[1];
		Logger.check(	FAILED_TO_CREATE_GRAPHICS_PIPELINE,
						() -> vkCreateGraphicsPipelines(device, VK_NULL_HANDLE, info, null, aId));
		pipelinePtr = aId[0];
	}

	@Override
	public void free(IGraphicContext context)
	{
		final var device = context.getVkDevice();
		vkDestroyPipeline(device, pipelinePtr, null);
		pipelinePtr = 0;
	}

	@Override
	public long getPipelinePtr()
	{
		return pipelinePtr;
	}
}
