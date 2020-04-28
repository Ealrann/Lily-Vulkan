package org.sheepy.lily.vulkan.process.pipeline.task;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import java.util.stream.Collectors;

@ModelExtender(scope = BindDescriptorSets.class)
@Adapter
public final class BindDescriptorSetsAdapter implements IPipelineTaskAdapter<BindDescriptorSets>
{
	private boolean dirty = true;

	@NotifyChanged(featureIds = ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS)
	public void notifyChanged(Notification notification)
	{
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

		final var sets = task.getDescriptorSets()
							 .stream()
							 .map(set -> set.allocationHandle(IDescriptorSetAllocation.class).get())
							 .collect(Collectors.toUnmodifiableList());

		pipelineLayout.bindDescriptors(commandBuffer, sets, bindPoint);

		dirty = false;
	}

	@Override
	public boolean needRecord(BindDescriptorSets task, int index)
	{
		return dirty;
	}
}
