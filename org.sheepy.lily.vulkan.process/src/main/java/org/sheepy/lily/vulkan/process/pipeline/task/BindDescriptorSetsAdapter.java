package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.IPipeline;

@Adapter(scope = BindDescriptorSets.class)
public final class BindDescriptorSetsAdapter implements IPipelineTaskAdapter<BindDescriptorSets>
{
	@Override
	public void record(BindDescriptorSets task, RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(task, IPipeline.class);
		final var pipelineAdapter = IPipelineAdapter.adapt(pipeline);
		final var pipelineLayout = pipelineAdapter.getVkPipelineLayout();

		pipelineLayout.bindDescriptors(context.commandBuffer, context.bindPoint);
	}
}
