package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;

@Statefull
@Adapter(scope = ComputePipeline.class)
public final class ComputePipelineAdapter extends AbstractPipelineAdapter<IProcessContext>
{
	private final ComputePipeline pipeline;

	private VkComputePipeline vkPipeline = null;

	public ComputePipelineAdapter(ComputePipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(IProcessContext context)
	{
		super.allocate(context);

		final var shader = pipeline.getShader();
		final var shaderAdapter = shader.adaptNotNull(IShaderAdapter.class);
		final var shaderStage = shaderAdapter.getVkShaderStage();
		final var specializationData = pipeline.getSpecializationData();
		final var specializationBuffer = specializationData != null
				? specializationData.getData()
				: null;

		vkPipeline = new VkComputePipeline(	getVkPipelineLayout(),
											shaderStage,
											specializationBuffer);
		vkPipeline.allocate(context);
	}

	@Override
	public void free(IProcessContext context)
	{
		vkPipeline.free(context);
		vkPipeline = null;

		super.free(context);
	}

//	public long getPipelineId(int index)
//	{
//		return vkPipelines.get(index).getPipelineId();
//	}

	@Override
	public VkComputePipeline getVkPipeline()
	{
		return vkPipeline;
	}
}
