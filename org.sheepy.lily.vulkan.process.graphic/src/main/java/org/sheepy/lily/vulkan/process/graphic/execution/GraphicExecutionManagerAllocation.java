package org.sheepy.lily.vulkan.process.graphic.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.IExecutionManagerAdapter;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

@ModelExtender(scope = GraphicExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicPackage.GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS)
@AllocationChild(features = GraphicPackage.GRAPHIC_EXECUTION_MANAGER__ACQUIRER)
@AllocationChild(features = GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
public final class GraphicExecutionManagerAllocation extends ExecutionManagerAllocation<GraphicExecutionRecorderAllocation> implements
																															IExecutionManagerAdapter
{
	private final VkSemaphore presentSemaphore;
	private final int executionCount;
	private final IAllocationState allocationState;

	private List<GraphicExecutionRecorderAllocation> recorders;

	private GraphicExecutionManagerAllocation(GraphicExecutionManager executionManager,
											  ProcessContext context,
											  IAllocationState allocationState,
											  @InjectDependency(index = 0) SwapChainAllocation swapChainAllocation)
	{
		super(executionManager, context);

		this.presentSemaphore = new VkSemaphore(context.getVkDevice(), "GraphicExecutionRecorderAllocation");
		this.allocationState = allocationState;
		this.executionCount = swapChainAllocation.getImageCount();
		setupRecorders(executionManager, executionCount);
	}

	@UpdateDependency(index = 0)
	private void updateSwaptChain(SwapChainAllocation swapChainAllocation)
	{
		if (executionCount != swapChainAllocation.getImageCount())
		{
			allocationState.setAllocationObsolete();
		}
	}

	@InjectChildren(index = 2, type = GraphicExecutionRecorderAllocation.class)
	private void injectRecorders(List<GraphicExecutionRecorderAllocation> recorders)
	{
		this.recorders = recorders;
	}

	@Free
	private void free(ProcessContext context)
	{
		final var vkDevice = context.getVkDevice();
		presentSemaphore.free(vkDevice);
	}

	@Override
	protected List<VkSemaphore> signalSemaphores()
	{
		return List.of(presentSemaphore);
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
			executionManager.setAcquirer(GraphicFactory.eINSTANCE.createGraphicAcquirer());

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
