package org.sheepy.lily.vulkan.process.pipeline.task;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineRecordable;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import java.util.stream.Collectors;

@ModelExtender(scope = BindDescriptorSets.class)
@Adapter
public final class BindDescriptorSetsRecorder implements IPipelineTaskRecorder
{
	private final BindDescriptorSets task;
	private boolean dirty = true;

	private BindDescriptorSetsRecorder(BindDescriptorSets task)
	{
		this.task = task;
	}

	@NotifyChanged(featureIds = ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS)
	public void notifyChanged(Notification notification)
	{
		dirty = true;
	}

	@Override
	public void record(RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(task, AbstractPipeline.class);
		final var pipelineAdapter = pipeline.adapt(IVkPipelineRecordable.class);
		final var pipelineLayout = pipelineAdapter.getVkPipelineLayout();
		final int bindPoint = task.getBindPoint().getValue();
		final var commandBuffer = context.commandBuffer;

		final var sets = task.getDescriptorSets()
							 .stream()
							 .map(set -> set.adapt(IDescriptorSetAllocation.class))
							 .collect(Collectors.toUnmodifiableList());

		pipelineLayout.bindDescriptors(commandBuffer, sets, bindPoint);

		dirty = false;
	}

	@Override
	public boolean isRecordDirty(final int index)
	{
		return dirty;
	}
}
