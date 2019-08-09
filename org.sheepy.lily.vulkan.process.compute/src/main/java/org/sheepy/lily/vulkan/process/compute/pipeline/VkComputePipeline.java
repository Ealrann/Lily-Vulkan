package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;
import org.sheepy.vulkan.pipeline.VkShaderStage;

public class VkComputePipeline extends VkPipeline<IProcessContext>
{
	private final VkPipelineLayout<? super IProcessContext> pipelineLayout;
	private final VkShaderStage shaderStage;
	private final ByteBuffer specializationData;

	protected long[] pipelineIds;

	public VkComputePipeline(	VkPipelineLayout<? super IProcessContext> pipelineLayout,
								VkShaderStage shaderStage,
								ByteBuffer specializationData)
	{
		super(VK_PIPELINE_BIND_POINT_COMPUTE);

		this.pipelineLayout = pipelineLayout;
		this.shaderStage = shaderStage;
		this.specializationData = specializationData;

		pipelineIds = new long[1];
		pipelineIds[0] = -1;
	}

	@Override
	public void allocate(MemoryStack stack, IProcessContext context)
	{
		final var device = context.getVkDevice();

		// Create Pipeline
		// -----------------------
		final var pipelineCreateInfos = VkComputePipelineCreateInfo.callocStack(1, stack);

		final var pipelineCreateInfo = pipelineCreateInfos.get();
		pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
		pipelineCreateInfo.layout(pipelineLayout.getId());
		shaderStage.fillInfo(stack, pipelineCreateInfo.stage(), specializationData);

		pipelineCreateInfos.flip();

		Logger.check("Failed to create compute pipeline!", () -> vkCreateComputePipelines(device,
				VK_NULL_HANDLE, pipelineCreateInfos, null, pipelineIds));
	}

	@Override
	public void free(IProcessContext context)
	{
		final var device = context.getVkDevice();

		for (int i = 0; i < pipelineIds.length; i++)
		{
			final long pipelineId = pipelineIds[i];
			vkDestroyPipeline(device, pipelineId, null);
			pipelineIds[i] = -1;
		}
	}

	@Override
	public boolean isAllocationDirty(IProcessContext context)
	{
		return false;
	}

	@Override
	protected long getPipelineId()
	{
		return pipelineIds[0];
	}
}
