package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import java.util.List;

@ModelExtender(scope = BindDescriptorSets.class)
@Allocation
@AllocationDependency(features = ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS, type = IDescriptorSetAllocation.class)
public final class BindDescriptorSetsRecorder implements IRecordableExtender
{
	private final BindDescriptorSets task;
	private final List<IDescriptorSetAllocation> descriptorSets;
	private final int bindPoint;
	private final AbstractPipeline pipeline;

	private BindDescriptorSetsRecorder(BindDescriptorSets task,
									   @InjectDependency(index = 0) List<IDescriptorSetAllocation> descriptorSets)
	{
		pipeline = ModelUtil.findParent(task, AbstractPipeline.class);

		this.task = task;
		this.descriptorSets = descriptorSets;
		this.bindPoint = task.getBindPoint().getValue();
	}

	@Override
	public void record(RecordContext context)
	{
		final var commandBuffer = context.commandBuffer;
		final var descriptorSetsToBind = getDSToBind(context.index, task.getStride());
		final var pipelineAdapter = pipeline.adapt(IPipelineAllocation.class);
		final var pipelineLayout = pipelineAdapter.getVkPipelineLayout();

		for (final var ds : descriptorSetsToBind)
		{
			ds.attach(context);
		}

		pipelineLayout.bindDescriptors(commandBuffer, descriptorSetsToBind, bindPoint);
	}

	private List<IDescriptorSetAllocation> getDSToBind(final int index, final int stride)
	{
		if (stride == 0)
		{
			return descriptorSets;
		}
		else
		{
			final int start = index * stride;
			return descriptorSets.subList(start, start + stride);
		}
	}
}
