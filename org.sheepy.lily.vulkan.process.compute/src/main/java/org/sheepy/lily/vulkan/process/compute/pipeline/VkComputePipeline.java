package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.sheepy.lily.vulkan.core.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.nio.ByteBuffer;

import static org.lwjgl.vulkan.VK10.*;

public class VkComputePipeline extends VkPipeline<ProcessContext>
{
	private static final String FAILED_TO_CREATE_COMPUTE_PIPELINE = "Failed to create compute pipeline";
	private final VkPipelineLayout pipelineLayout;
	private final VkShaderStage shaderStage;
	private final ByteBuffer specializationData;

	protected long pipelinePtr = 0;

	public VkComputePipeline(VkPipelineLayout pipelineLayout, VkShaderStage shaderStage, ByteBuffer specializationData)
	{
		super(VK_PIPELINE_BIND_POINT_COMPUTE);

		this.pipelineLayout = pipelineLayout;
		this.shaderStage = shaderStage;
		this.specializationData = specializationData;
	}

	@Override
	public void allocate(ProcessContext context)
	{
		final var stack = context.stack();
		final var device = context.getVkDevice();

		// Create Pipeline
		// -----------------------
		final var pipelineCreateInfos = VkComputePipelineCreateInfo.callocStack(1, stack);

		final var pipelineCreateInfo = pipelineCreateInfos.get();
		pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
		pipelineCreateInfo.layout(pipelineLayout.getId());
		shaderStage.fillInfo(stack, pipelineCreateInfo.stage(), specializationData);
		pipelineCreateInfos.flip();

		final var pPipelineId = stack.mallocLong(1);
		Logger.check(FAILED_TO_CREATE_COMPUTE_PIPELINE,
					 () -> vkCreateComputePipelines(device, VK_NULL_HANDLE, pipelineCreateInfos, null, pPipelineId));

		pipelinePtr = pPipelineId.get(0);
	}

	@Override
	public void free(ProcessContext context)
	{
		final var device = context.getVkDevice();
		vkDestroyPipeline(device, pipelinePtr, null);
		pipelinePtr = 0;
	}

	@Override
	protected long getPipelinePtr()
	{
		return pipelinePtr;
	}
}
