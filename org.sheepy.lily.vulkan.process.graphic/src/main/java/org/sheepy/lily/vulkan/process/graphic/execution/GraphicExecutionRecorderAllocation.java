package org.sheepy.lily.vulkan.process.graphic.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ICommandBufferAdapter;
import org.sheepy.lily.vulkan.process.execution.IExecutionRecorderAllocation;
import org.sheepy.lily.vulkan.process.execution.SubmissionAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.execution.util.FenceManager;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

@ModelExtender(scope = GraphicExecutionRecorder.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ProcessPackage.EXECUTION_RECORDER__SUBMISSION)
@AllocationDependency(features = GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER, type = ICommandBufferAdapter.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS}, type = ImageViewAllocation.class)
public final class GraphicExecutionRecorderAllocation implements IExecutionRecorderAllocation
{
	private final FenceManager fenceManager;
	private final PresentSubmission presentSubmission;
	private SubmissionAllocation submissionAllocation;
	private ICommandBufferAdapter commandBuffer;

	private GraphicExecutionRecorderAllocation(GraphicExecutionRecorder recorder,
											   ProcessContext context,
											   @InjectDependency(index = 0) ICommandBufferAdapter commandBuffer,
											   @InjectDependency(index = 1) PhysicalSurfaceAllocation surfaceAllocation,
											   @InjectDependency(index = 2) SwapChainAllocation swapChainAllocation)
	{
		final int index = recorder.getCommandBuffer().getIndex();
		final var presentQueue = surfaceAllocation.getPresentQueue().vkQueue;
		final var manager = (GraphicExecutionManager) recorder.eContainer();
		final var presentSemaphore = manager.adapt(GraphicExecutionManagerAllocation.class).getPresentSemaphore();
		this.commandBuffer = commandBuffer;
		fenceManager = new FenceManager(context.getVkDevice());
		this.presentSubmission = new PresentSubmission(swapChainAllocation.getPtr(),
													   presentQueue,
													   index,
													   presentSemaphore);
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
	public void prepare(final List<WaitData> waitSemaphores, List<VkSemaphore> signalSemaphores, int semaphoreCount)
	{
		fenceManager.waitIdle();
		fenceManager.setUsed(true);
		submissionAllocation.prepare(waitSemaphores, signalSemaphores, semaphoreCount, fenceManager);

		commandBuffer.prepare(fenceManager);
	}

	@Free
	public void free(ExecutionContext context)
	{
		presentSubmission.free();
		fenceManager.free();
	}

	@Override
	public IFenceView play()
	{
		fenceManager.start();
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		if (submissionAllocation.play(vkCommandBuffer, fenceManager))
		{
			presentSubmission.submit();
		}
		else
		{
			fenceManager.cancel();
		}
		return fenceManager.getFence();
	}

	@Override
	public boolean checkFence()
	{
		return fenceManager.checkFence();
	}

	@Override
	public void waitIdle()
	{
		fenceManager.waitIdle();
	}

	@Override
	public VkSemaphore borrowSemaphore()
	{
		return submissionAllocation.borrowSemaphore();
	}
}
