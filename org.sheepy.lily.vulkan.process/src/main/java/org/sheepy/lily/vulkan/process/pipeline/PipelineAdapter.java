package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.Pipeline;

@Statefull
@Adapter(scope = Pipeline.class)
public class PipelineAdapter<T extends IVulkanContext> extends AbstractTaskPipelineAdapter<T>
{
	public PipelineAdapter(AbstractPipeline pipeline)
	{
		super(pipeline);
	}

	@Override
	public void allocate(T context)
	{
	}

	@Override
	public void free(T context)
	{
	}
}
