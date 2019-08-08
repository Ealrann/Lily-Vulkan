package org.sheepy.lily.vulkan.process.pipeline.task;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;

@Statefull
@Adapter(scope = BindDescriptorSets.class)
public final class BindDescriptorSetsAdapter implements IPipelineTaskAdapter<BindDescriptorSets>
{
	private final List<IVkDescriptorSet> sets;

	public BindDescriptorSetsAdapter(BindDescriptorSets task)
	{
		final List<IVkDescriptorSet> tmpList = new ArrayList<>();
		for (final var modelSet : task.getDescriptorSets())
		{
			tmpList.add(IDescriptorSetAdapter.adapt(modelSet));
		}
		sets = List.copyOf(tmpList);
	}

	@Override
	public void record(BindDescriptorSets task, RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(task, IPipeline.class);
		final var pipelineAdapter = IPipelineAdapter.adapt(pipeline);
		final var pipelineLayout = pipelineAdapter.getVkPipelineLayout();
		final int bindPoint = task.getBindPoint().getValue();

		pipelineLayout.bindDescriptors(context.commandBuffer, sets, bindPoint);
	}
}
