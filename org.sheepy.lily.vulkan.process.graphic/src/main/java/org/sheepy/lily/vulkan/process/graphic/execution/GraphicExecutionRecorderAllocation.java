package org.sheepy.lily.vulkan.process.graphic.execution;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
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
@AllocationChild(features = ExecutionRecorder.FeatureIDs.SUBMISSION)
@AllocationDependency(features = GraphicExecutionRecorder.FeatureIDs.COMMAND_BUFFERS, type = ICommandBufferAdapter.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicProcess.FeatureIDs.CONFIGURATION, GraphicConfiguration.FeatureIDs.SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicProcess.FeatureIDs.CONFIGURATION, GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicProcess.FeatureIDs.CONFIGURATION, GraphicConfiguration.FeatureIDs.IMAGE_VIEWS}, type = ImageViewAllocation.class)
public final class GraphicExecutionRecorderAllocation implements IExecutionRecorderAllocation
{
	private final PresentSubmission presentSubmission;
	private final GraphicExecutionManagerAllocation managerAllocation;
	private SubmissionAllocation submissionAllocation;
	private List<ICommandBufferAdapter> commandBuffers;
	private int currentIndex;
	private FenceManager currentFenceManager;

	private GraphicExecutionRecorderAllocation(GraphicExecutionRecorder recorder,
											   ProcessContext context,
											   @InjectDependency(index = 0) List<ICommandBufferAdapter> commandBuffers,
											   @InjectDependency(index = 1) PhysicalSurfaceAllocation surfaceAllocation,
											   @InjectDependency(index = 2) SwapChainAllocation swapChainAllocation)
	{
		final int imageID = recorder.commandBuffers().get(0).imageID();
		assert recorder.commandBuffers().stream().filter(cb -> cb.imageID() != imageID).findAny().isEmpty();
		final var presentQueue = surfaceAllocation.getPresentQueue().vkQueue;
		final var manager = (GraphicExecutionManager) recorder.lmContainer();
		managerAllocation = manager.adaptNotNull(GraphicExecutionManagerAllocation.class);
		final var presentSemaphore = managerAllocation.getPresentSemaphore(imageID);
		this.commandBuffers = commandBuffers;
		this.presentSubmission = new PresentSubmission(swapChainAllocation.getPtr(),
													   presentQueue,
													   imageID,
													   presentSemaphore);
	}

	@InjectChildren(index = 0, type = SubmissionAllocation.class)
	private void updateSubmission(SubmissionAllocation submissionAllocation)
	{
		this.submissionAllocation = submissionAllocation;
	}

	@UpdateDependency(index = 0)
	private void updateCommandBuffer(List<ICommandBufferAdapter> commandBuffers)
	{
		this.commandBuffers = commandBuffers;
	}

	@Override
	public void prepare(final List<WaitData> waitSemaphores,
						final List<VkSemaphore> signalSemaphores,
						final int semaphoreCount,
						final int recordIndex)
	{
		currentIndex = recordIndex;
		currentFenceManager = managerAllocation.getFrameFence(recordIndex);
		currentFenceManager.waitIdle();
		currentFenceManager.setUsed(true);
		submissionAllocation.prepare(waitSemaphores, signalSemaphores, semaphoreCount, currentFenceManager);

		final var commandBufferAdapter = commandBuffers.get(currentIndex);
		commandBufferAdapter.prepare(currentFenceManager);
	}

	@Free
	public void free(ExecutionContext context)
	{
		presentSubmission.free();
	}

	@Override
	public IFenceView play()
	{
		currentFenceManager.start();
		final var vkCommandBuffer = commandBuffers.get(currentIndex).getVkCommandBuffer();
		if (submissionAllocation.play(vkCommandBuffer, currentFenceManager))
		{
			presentSubmission.submit();
		}
		else
		{
			currentFenceManager.cancel();
		}
		return currentFenceManager.getFence();
	}

	@Override
	public boolean checkFence()
	{
		return currentFenceManager != null && currentFenceManager.checkFence();
	}

	@Override
	public void waitIdle()
	{
		if (currentFenceManager != null)
		{
			currentFenceManager.waitIdle();
		}
	}

	@Override
	public VkSemaphore borrowSemaphore()
	{
		return submissionAllocation.borrowSemaphore();
	}
}
