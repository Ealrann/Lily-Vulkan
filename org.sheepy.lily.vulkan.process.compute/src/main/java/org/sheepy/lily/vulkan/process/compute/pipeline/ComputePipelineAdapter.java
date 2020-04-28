package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.resource.IShaderAllocation;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.pipeline.AbstractVkPipelineAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = ComputePipeline.class)
@Adapter
public final class ComputePipelineAdapter extends AbstractVkPipelineAdapter<ProcessContext<?>>
{
	private final ComputePipeline pipeline;

	private VkComputePipeline vkPipeline = null;

	public ComputePipelineAdapter(ComputePipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(ProcessContext<?> context)
	{
		super.allocate(context);

		final var shader = pipeline.getShader();
		final var shaderAdapter = shader.allocationHandle(IShaderAllocation.class).get();
		final var shaderStage = shaderAdapter.getVkShaderStage();
		final var specializationData = pipeline.getSpecializationData();
		final var specializationBuffer = specializationData != null ? specializationData.getData() : null;

		vkPipeline = new VkComputePipeline(getVkPipelineLayout(), shaderStage, specializationBuffer);
		vkPipeline.allocate(context);
	}

	@Override
	public void free(ProcessContext<?> context)
	{
		vkPipeline.free(context);
		vkPipeline = null;

		super.free(context);
	}

	@Override
	public VkComputePipeline getVkPipeline()
	{
		return vkPipeline;
	}
}
