package org.sheepy.lily.vulkan.process.graphic.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorderHelper;
import org.sheepy.lily.vulkan.process.execution.ICommandBufferAdapter;
import org.sheepy.lily.vulkan.process.execution.IExecutionRecorderAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

@ModelExtender(scope = GraphicExecutionRecorder.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(features = GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER, type = ICommandBufferAdapter.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS}, type = ImageViewAllocation.class)
public final class GraphicExecutionRecorderAllocation implements IExecutionRecorderAllocation
{
	private final PresentSubmission presentSubmission;
	private final ExecutionRecorderHelper executionHelper;
	private ICommandBufferAdapter commandBuffer;

	private GraphicExecutionRecorderAllocation(GraphicExecutionRecorder recorder,
											   ProcessContext context,
											   IAllocationState allocationState,
											   @InjectDependency(index = 0) ICommandBufferAdapter commandBuffer,
											   @InjectDependency(index = 1) PhysicalSurfaceAllocation surfaceAllocation,
											   @InjectDependency(index = 2) SwapChainAllocation swapChainAllocation)
	{
		final int index = recorder.getCommandBuffer().getIndex();
		assert index == recorder.getIndex();
		final var presentQueue = surfaceAllocation.getPresentQueue().vkQueue;
		final var manager = (GraphicExecutionManager) recorder.eContainer();
		final var presentSemaphore = manager.adapt(GraphicExecutionManagerAllocation.class).getPresentSemaphore();
		this.commandBuffer = commandBuffer;
		this.executionHelper = new ExecutionRecorderHelper(context, allocationState, 1);
		this.presentSubmission = new PresentSubmission(swapChainAllocation.getPtr(),
													   presentQueue,
													   index,
													   presentSemaphore);

		System.out.println("Allocate GraphicExecutionRecorder " + index);
	}

	@UpdateDependency(index = 0)
	private void updateCommandBuffer(ICommandBufferAdapter commandBuffer)
	{
		this.commandBuffer = commandBuffer;
	}

	@Override
	public void prepare(final List<WaitData> waitSemaphores, List<VkSemaphore> signalSemaphores, int semaphoreCount)
	{
		executionHelper.prepare(waitSemaphores, signalSemaphores, semaphoreCount, commandBuffer);
	}

	@Free
	public void free(ExecutionContext context)
	{
		executionHelper.free(context.getVkDevice());
		presentSubmission.free();
	}

	@Override
	public IFenceView play()
	{
		final var res = executionHelper.play();
		if (res.result() == VK_SUCCESS)
		{
			presentSubmission.submit();
		}
		return res.fence();
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
	public VkSemaphore borrowSemaphore()
	{
		return executionHelper.borrowSemaphore();
	}
}
