package org.sheepy.lily.vulkan.process.compute.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.process.execution.ICommandBufferAdapter;
import org.sheepy.lily.vulkan.process.execution.IExecutionRecorderAllocation;
import org.sheepy.lily.vulkan.process.execution.SubmissionAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.execution.util.FenceManager;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

@ModelExtender(scope = ComputeExecutionRecorder.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ProcessPackage.EXECUTION_RECORDER__SUBMISSION)
@AllocationDependency(features = ComputePackage.COMPUTE_EXECUTION_RECORDER__COMMAND_BUFFER, type = ICommandBufferAdapter.class)
public final class ComputeExecutionRecorderAllocation implements IExecutionRecorderAllocation
{
	private final FenceManager fenceManager;
	private SubmissionAllocation submissionAllocation;
	private ICommandBufferAdapter commandBuffer;

	private ComputeExecutionRecorderAllocation(ProcessContext context,
											   @InjectDependency(index = 0) ICommandBufferAdapter commandBuffer)
	{
		this.commandBuffer = commandBuffer;
		fenceManager = new FenceManager(context.getVkDevice());
	}

	@InjectChildren(index = 0, type = SubmissionAllocation.class)
	private void updateSubmission(SubmissionAllocation submissionAllocation)
	{
		this.submissionAllocation = submissionAllocation;
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
		final var syncUnit = submissionAllocation.prepare(waitSemaphores, signalSemaphores, executionSemaphoreCount);

		commandBuffer.prepare(syncUnit);
	}

	@Override
	public boolean checkFence()
	{
		return submissionAllocation.checkFence();
	}

	@Override
	public void waitIdle()
	{
		submissionAllocation.waitIdle();
	}

	@Override
	public IFenceView play()
	{
		return submissionAllocation.play(commandBuffer.getVkCommandBuffer()).fence();
	}

	@Override
	public VkSemaphore borrowSemaphore()
	{
		return submissionAllocation.borrowSemaphore();
	}

	@Override
	public FenceManager getFenceManager()
	{
		return fenceManager;
	}
}
