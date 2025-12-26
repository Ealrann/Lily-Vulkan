package org.sheepy.lily.vulkan.process.compute.execution;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.process.execution.AbstractCommandBufferAllocation;
import org.sheepy.lily.vulkan.process.execution.AbstractProcessCommandBufferHelper;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

@ModelExtender(scope = ComputeCommandBuffer.class)
@Allocation(context = ProcessContext.class, reuseDirtyAllocations = true)
@AllocationDependency(parent = ComputeProcess.class, features = {ComputeProcess.FeatureIDs.PIPELINE_PKG, PipelinePkg.FeatureIDs.PIPELINES}, type = IRecordableAdapter.class)
public final class ComputeCommandBufferAllocation extends AbstractCommandBufferAllocation
{
	private ComputeCommandBufferAllocation(ComputeCommandBuffer commandBuffer,
										   IAllocationState allocationState,
										   ProcessContext context,
										   @InjectDependency(index = 0) List<IRecordableAdapter> recordables)
	{
		super(new ComputeCommandBufferHelper(context, buildRecordInfo(commandBuffer)), context, allocationState);
		changeRecordables(recordables);
	}

	@UpdateDependency(index = 0)
	private void updateRecorders(List<IRecordableAdapter> recordables)
	{
		changeRecordables(recordables);
	}

	private static AbstractProcessCommandBufferHelper.RecordInfo buildRecordInfo(final ComputeCommandBuffer commandBuffer)
	{
		return new AbstractProcessCommandBufferHelper.RecordInfo(commandBuffer.index(), commandBuffer.index());
	}
}
