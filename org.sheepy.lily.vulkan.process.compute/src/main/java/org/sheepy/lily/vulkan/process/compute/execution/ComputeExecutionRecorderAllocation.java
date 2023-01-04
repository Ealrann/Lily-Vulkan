package org.sheepy.lily.vulkan.process.compute.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorderHelper;
import org.sheepy.lily.vulkan.process.execution.ICommandBufferAdapter;
import org.sheepy.lily.vulkan.process.execution.IExecutionRecorderAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

@ModelExtender(scope = ComputeExecutionRecorder.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(features = ComputePackage.COMPUTE_EXECUTION_RECORDER__COMMAND_BUFFER, type = ICommandBufferAdapter.class)
public final class ComputeExecutionRecorderAllocation implements IExecutionRecorderAllocation
{
	private final ExecutionRecorderHelper executionHelper;
	private ICommandBufferAdapter commandBuffer;

	private ComputeExecutionRecorderAllocation(ComputeExecutionRecorder recorder,
											   ProcessContext context,
											   IAllocationState config,
											   @InjectDependency(index = 0) ICommandBufferAdapter commandBuffer)
	{
		final var manager = (ComputeExecutionManager) recorder.eContainer();
		final int queuedExecutionCount = manager.getIndexCount() > 1 ? 1 : 2;
		this.commandBuffer = commandBuffer;
		this.executionHelper = new ExecutionRecorderHelper(context, config, queuedExecutionCount);
	}

	@UpdateDependency(index = 0)
	private void updateCommandBuffer(ICommandBufferAdapter commandBuffer)
	{
		this.commandBuffer = commandBuffer;
	}

	@Override
	public void prepare(final List<WaitData> waitSemaphores,
						List<VkSemaphore> signalSemaphores,
						int executionSemaphoreCount)
	{
		executionHelper.prepare(waitSemaphores, signalSemaphores, executionSemaphoreCount, commandBuffer);
	}

	@Free
	public void free(ExecutionContext context)
	{
		executionHelper.free(context.getVkDevice());
	}

	@Override
	public boolean checkFence()
	{
		return executionHelper.checkFence();
	}

	@Override
	public void waitIdle()
	{
		executionHelper.waitIdle();
	}

	@Override
	public IFenceView play()
	{
		return executionHelper.play().fence();
	}

	@Override
	public VkSemaphore borrowSemaphore()
	{
		return executionHelper.borrowSemaphore();
	}
}
