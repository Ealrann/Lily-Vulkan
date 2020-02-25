package org.sheepy.lily.vulkan.process.pipeline.task;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.core.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import java.util.ArrayList;
import java.util.List;

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
	public void record(BindDescriptorSets task, IRecordContext context)
	{
		final var pipeline = ModelUtil.findParent(task, AbstractPipeline.class);
		final var pipelineAdapter = pipeline.<IVkPipelineAdapter<?>>adaptNotNullGeneric(IPipelineAdapter.class);
		final var pipelineLayout = pipelineAdapter.getVkPipelineLayout();
		final int bindPoint = task.getBindPoint().getValue();
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		pipelineLayout.bindDescriptors(commandBuffer, sets, bindPoint);

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
