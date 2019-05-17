package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.sheepy.lily.vulkan.api.process.IComputeContext;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.pipeline.IShaderStageFiller;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;

public class VkComputePipeline extends VkPipeline<IComputeContext>
{
	private final IShaderStageFiller shader;

	protected long[] pipelineIds;

	private final VkPipelineLayout<? super IComputeContext> pipelineLayout;

	public VkComputePipeline(	VkPipelineLayout<? super IComputeContext> pipelineLayout,
								IShaderStageFiller shader)
	{
		this.pipelineLayout = pipelineLayout;
		this.shader = shader;

		pipelineIds = new long[1];
		pipelineIds[0] = -1;
	}

	@Override
	public void allocate(MemoryStack stack, IComputeContext context)
	{
		final var device = context.getVkDevice();

		// Create Pipeline
		// -----------------------
		final var pipelineCreateInfos = VkComputePipelineCreateInfo.callocStack(1, stack);

		final var pipelineCreateInfo = pipelineCreateInfos.get();
		pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
		pipelineCreateInfo.layout(pipelineLayout.getId());
		shader.fillInfo(pipelineCreateInfo.stage());

		pipelineCreateInfos.flip();

		Logger.check("Failed to create compute pipeline!", () -> vkCreateComputePipelines(device,
				VK_NULL_HANDLE, pipelineCreateInfos, null, pipelineIds));
	}

	@Override
	public void free(IComputeContext context)
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
	public boolean isAllocationDirty(IComputeContext context)
	{
		return false;
	}

	@Override
	protected long getPipelineId()
	{
		return pipelineIds[0];
	}
}
