package org.sheepy.lily.vulkan.process.pipeline;

import java.util.Collections;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.vulkan.pipeline.VkPipeline;

@Statefull
@Adapter(scope = Pipeline.class)
public class PipelineAdapter<T extends IProcessContext> extends AbstractPipelineAdapter<T>
{
	public PipelineAdapter(IPipeline pipeline)
	{
		super(pipeline);
	}

	@Override
	public List<? extends VkPipeline<? super T>> getVkPipelines()
	{
		return Collections.emptyList();
	}
}
