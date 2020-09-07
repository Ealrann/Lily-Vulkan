package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.joml.Vector2ic;
import org.lwjgl.vulkan.VkGraphicsPipelineCreateInfo;
import org.sheepy.lily.vulkan.core.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.process.graphic.pipeline.builder.*;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.pipeline.builder.ShaderStageBuilder;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.graphicpipeline.*;

import java.nio.ByteBuffer;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public final class VkGraphicsPipeline extends VkPipeline
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

	private final VkPipelineLayout pipelineLayout;
	private final ColorBlend colorBlend;
	private final Rasterizer rasterizer;
	private final InputAssembly inputAssembly;
	private final ViewportState viewportState;
	private final DynamicState dynamicState;
	private final DepthStencilState depthStencilState;
	private final VkInputStateDescriptor vertexDescriptor;
	private final List<VkShaderStage> shaderStages;
	private final ByteBuffer specializationData;
	private final int subpass;

	private long pipelinePtr = 0;

	public VkGraphicsPipeline(VkPipelineLayout pipelineLayout,
							  ColorBlend colorBlend,
							  Rasterizer rasterizer,
							  InputAssembly inputAssembly,
							  ViewportState viewportState,
							  DynamicState dynamicState,
							  DepthStencilState depthStencilState,
							  VkInputStateDescriptor vertexBufferDescriptor,
							  List<VkShaderStage> shaderStages,
							  ByteBuffer specializationData,
							  int subpass)
	{
		super(VK_PIPELINE_BIND_POINT_GRAPHICS);

		this.pipelineLayout = pipelineLayout;
		this.colorBlend = colorBlend;
		this.rasterizer = rasterizer;
		this.inputAssembly = inputAssembly;
		this.viewportState = viewportState;
		this.dynamicState = dynamicState;
		this.depthStencilState = depthStencilState;
		this.vertexDescriptor = vertexBufferDescriptor;
		this.shaderStages = shaderStages;
		this.specializationData = specializationData;
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

	public void allocate(ProcessContext context, Vector2ic extent, RenderPassAllocation renderPassAllocation)
	{
		final var device = context.getVkDevice();
		final var stack = context.stack();

		// Create Pipeline
		// -----------------------
		final var info = VkGraphicsPipelineCreateInfo.callocStack(1, stack);
		info.sType(VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_CREATE_INFO);
		info.pStages(shaderStageBuilder.allocShaderStageInfo(stack, shaderStages, specializationData));
		info.pVertexInputState(vertexDescriptor.allocCreateInfo(stack));
		info.pInputAssemblyState(inputAssemblyBuilder.allocCreateInfo(stack, inputAssembly));
		info.pViewportState(viewportStateBuilder.allocCreateInfo(stack, extent, viewportState));
		info.pRasterizationState(rasterizerBuilder.allocCreateInfo(stack, rasterizer));
		info.pMultisampleState(multisampleBuilder.allocCreateInfo(stack));
		if (depthStencilState != null)
			info.pDepthStencilState(depthStencilBuidler.allocCreateInfo(stack, depthStencilState));
		info.pColorBlendState(colorBlendBuilder.allocCreateInfo(stack, colorBlend));
		if (dynamicState != null) info.pDynamicState(dynamicStateBuilder.allocCreateInfo(stack, dynamicState));

		info.layout(pipelineLayout.getPtr());
		info.renderPass(renderPassAllocation.getPtr());
		info.subpass(subpass);
		info.basePipelineHandle(VK_NULL_HANDLE);
		info.basePipelineIndex(-1);

		final long[] aId = new long[1];
		Logger.check(vkCreateGraphicsPipelines(device, VK_NULL_HANDLE, info, null, aId),
					 FAILED_TO_CREATE_GRAPHICS_PIPELINE);
		pipelinePtr = aId[0];
	}

	public void free(ProcessContext context)
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
