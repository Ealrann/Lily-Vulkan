package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.Pipeline;

@ModelExtender(scope = Pipeline.class)
@Adapter
public class PipelineAllocation extends AbstractTaskPipelineAllocation
{
	public PipelineAllocation(AbstractPipeline pipeline, IObservatoryBuilder observatory)
	{
		super(pipeline, observatory);
	}
}
