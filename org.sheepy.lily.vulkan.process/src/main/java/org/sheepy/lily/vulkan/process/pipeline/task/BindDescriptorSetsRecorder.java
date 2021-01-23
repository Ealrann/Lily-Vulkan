package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.vkCmdBindDescriptorSets;

@ModelExtender(scope = BindDescriptorSets.class)
@Allocation
@AllocationDependency(features = ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS, type = IDescriptorSetAllocation.class)
public final class BindDescriptorSetsRecorder implements IRecordableAdapter
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
		final var descriptorSetsToBind = getDSToBind(context.index, task.getStride());
		final var pipelineAdapter = pipeline.adapt(IPipelineAllocation.class);
		final var pipelineLayout = pipelineAdapter.getVkPipelineLayout();
		final var pipelineLayoutPtr = pipelineLayout.getPtr();

		bindDescriptors(context, descriptorSetsToBind, pipelineLayoutPtr);
	}

	private BindContext getDSToBind(final int index, final int stride)
	{
		if (stride == 0)
		{
			return new BindContext(descriptorSets.stream(), descriptorSets.size());
		}
		else
		{
			final int start = index * stride;
			final int end = start + stride;
			final var stream = IntStream.range(start, end).mapToObj(descriptorSets::get);
			return new BindContext(stream, end - start);
		}
	}

	private void bindDescriptors(IRecordContext recordContext, BindContext bindContext, long pipelineLayoutPtr)
	{
		if (bindContext.size() > 0)
		{
			final var descriptorSetAddressBuffer = recordContext.stack().mallocLong(bindContext.size());
			descriptorSetAddressBuffer.clear();

			final var it = bindContext.descriptorSets().iterator();
			while (it.hasNext())
			{
				final var set = it.next();
				set.attach(recordContext);
				descriptorSetAddressBuffer.put(set.getPtr());
			}
			descriptorSetAddressBuffer.flip();

			vkCmdBindDescriptorSets(recordContext.vkCommandBuffer(),
									bindPoint,
									pipelineLayoutPtr,
									0,
									descriptorSetAddressBuffer,
									null);
		}
	}

	private static record BindContext(Stream<IDescriptorSetAllocation> descriptorSets, int size)
	{
	}
}
