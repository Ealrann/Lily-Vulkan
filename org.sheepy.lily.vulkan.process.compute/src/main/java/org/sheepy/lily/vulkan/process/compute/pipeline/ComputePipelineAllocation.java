package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.resource.IShaderAllocation;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.pipeline.AbstractVkPipelineAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class)
public final class ComputePipelineAllocation extends AbstractVkPipelineAllocation<ProcessContext>
{
	private final VkComputePipeline vkPipeline;

	public ComputePipelineAllocation(ComputePipeline pipeline, IObservatoryBuilder observatory, ProcessContext context)
	{
		super(pipeline, observatory, context);

		final var shader = pipeline.getShader();
		final var shaderAdapter = shader.allocationHandle(IShaderAllocation.class).get();
		final var shaderStage = shaderAdapter.getVkShaderStage();
		final var specializationData = pipeline.getSpecializationData();
		final var specializationBuffer = specializationData != null ? specializationData.getData() : null;

		vkPipeline = new VkComputePipeline(getVkPipelineLayout(), shaderStage, specializationBuffer);
		vkPipeline.allocate(context);
	}

	@Free
	public void free(ProcessContext context)
	{
		vkPipeline.free(context);
	}

	@Override
	public VkComputePipeline getVkPipeline()
	{
		return vkPipeline;
	}
}
