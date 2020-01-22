package org.sheepy.lily.vulkan.process.pipeline.task;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.common.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.common.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;

@Statefull
@Adapter(scope = BindDescriptorSets.class)
public final class BindDescriptorSetsAdapter implements IPipelineTaskAdapter<BindDescriptorSets>
{
	private List<IVkDescriptorSet> sets;
	private boolean dirty = true;

	public BindDescriptorSetsAdapter(BindDescriptorSets task)
	{
		sets = reloadSetAdapters(task);
	}

	@NotifyChanged(featureIds = ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS)
	public void notifyChanged(Notification notification)
	{
		sets = reloadSetAdapters((BindDescriptorSets) notification.getNotifier());
		dirty = true;
	}

	@Override
	public void record(BindDescriptorSets task, RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(task, IPipeline.class);
		final var pipelineAdapter = pipeline.<IVkPipelineAdapter<?>> adaptNotNullGeneric(IPipelineAdapter.class);
		final var pipelineLayout = pipelineAdapter.getVkPipelineLayout();
		final int bindPoint = task.getBindPoint().getValue();

		pipelineLayout.bindDescriptors(context.stack, context.commandBuffer, sets, bindPoint);

		dirty = false;
	}

	private static List<IVkDescriptorSet> reloadSetAdapters(BindDescriptorSets task)
	{
		final List<IVkDescriptorSet> tmpList = new ArrayList<>();
		for (final var modelSet : task.getDescriptorSets())
		{
			tmpList.add(modelSet.adaptNotNull(IDescriptorSetAdapter.class));
		}
		return List.copyOf(tmpList);
	}

	@Override
	public boolean needRecord(BindDescriptorSets task, int index)
	{
		return dirty;
	}
}
