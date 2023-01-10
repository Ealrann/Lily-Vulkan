package org.sheepy.lily.vulkan.process.graphic.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.IExecutionManagerAdapter;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = GraphicExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicPackage.GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS)
@AllocationChild(features = GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
public final class GraphicExecutionManagerAllocation extends ExecutionManagerAllocation<GraphicExecutionRecorderAllocation> implements
																															IExecutionManagerAdapter
{
	private final VkSemaphore imageAvailableSemaphore;
	private final VkSemaphore presentSemaphore;
	private final ImageAcquirer imageAcquirer;
	private final int executionCount;
	private final EPipelineStage acquireWaitStage;

	private int recordIndex = -1;
	private List<GraphicExecutionRecorderAllocation> recorders;

	private GraphicExecutionManagerAllocation(GraphicExecutionManager executionManager,
											  ProcessContext context,
											  @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation,
											  @InjectDependency(index = 1) SwapChainAllocation swapChainAllocation)
	{
		super(executionManager, context);

		final var process = (GraphicProcess) executionManager.eContainer();
		final var vkDevice = context.getVkDevice();
		imageAvailableSemaphore = new VkSemaphore(vkDevice, "GraphicExecutionManagerAllocation");
		presentSemaphore = new VkSemaphore(context.getVkDevice(), "GraphicExecutionRecorderAllocation");
		acquireWaitStage = process.getConfiguration().getAcquireWaitStage();
		executionCount = swapChainAllocation.getImageCount();
		setupRecorders(executionManager, executionCount);
		imageAcquirer = new ImageAcquirer(vkDevice, surfaceAllocation, swapChainAllocation.getPtr());
	}

	@InjectChildren(index = 1, type = GraphicExecutionRecorderAllocation.class)
	private void injectRecorders(List<GraphicExecutionRecorderAllocation> recorders)
	{
		this.recorders = recorders;
	}

	@UpdateDependency(index = 0)
	private void updateSurface(PhysicalSurfaceAllocation surfaceAllocation)
	{
		imageAcquirer.updateSurface(surfaceAllocation);
	}

	@UpdateDependency(index = 1)
	private void updateSwapChain(SwapChainAllocation swapChainAllocation)
	{
		assert executionCount == swapChainAllocation.getImageCount();
		imageAcquirer.updateSwapChain(swapChainAllocation.getPtr());
	}

	@Free
	private void free(ProcessContext context)
	{
		final var vkDevice = context.getVkDevice();
		imageAvailableSemaphore.free(vkDevice);
		presentSemaphore.free(vkDevice);
	}

	@Override
	protected List<VkSemaphore> signalSemaphores()
	{
		return List.of(presentSemaphore);
	}

	@Override
	protected AcquisitionInfo acquire()
	{
		recordIndex = (recordIndex + 1) % executionCount;
		final int imageIndex = imageAcquirer.acquireNextImage(imageAvailableSemaphore.getPtr());
		return new AcquisitionInfo(imageIndex, recordIndex);
	}

	@Override
	protected Stream<WaitData> streamAcquireSemaphores()
	{
		return Stream.of(createAcquireSemaphoreData());
	}

	private WaitData createAcquireSemaphoreData()
	{
		return new WaitData(imageAvailableSemaphore, acquireWaitStage);
	}

	@Override
	protected List<GraphicExecutionRecorderAllocation> getRecorders()
	{
		return recorders;
	}

	public VkSemaphore getPresentSemaphore()
	{
		return presentSemaphore;
	}

	private static void setupRecorders(GraphicExecutionManager executionManager, int count)
	{
		final var recorders = executionManager.getRecorders();
		if (recorders.size() != count)
		{
			recorders.clear();
			executionManager.getCommandBuffers().clear();
			for (int imageID = 0; imageID < count; imageID++)
			{
				final var submission = ProcessFactory.eINSTANCE.createSubmission();

				final var executionRecorder = GraphicFactory.eINSTANCE.createGraphicExecutionRecorder();
				executionRecorder.setSubmission(submission);

				for (int index = 0; index < count; index++)
				{
					final var commandBuffer = GraphicFactory.eINSTANCE.createGraphicCommandBuffer();
					commandBuffer.setIndex(index);
					commandBuffer.setImageID(imageID);
					executionManager.getCommandBuffers().add(commandBuffer);
					executionRecorder.getCommandBuffers().add(commandBuffer);
				}

				recorders.add(executionRecorder);
			}
		}
	}
}
