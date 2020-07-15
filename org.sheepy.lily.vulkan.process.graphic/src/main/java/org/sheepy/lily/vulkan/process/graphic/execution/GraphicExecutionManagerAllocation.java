package org.sheepy.lily.vulkan.process.graphic.execution;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
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
@AllocationChild(features = GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
public final class GraphicExecutionManagerAllocation extends ExecutionManagerAllocation implements IExtender
{
	private final VkSemaphore imageAvailableSemaphore;
	private final ImageAcquirer imageAcquirer;
	private final int executionCount;
	private final EPipelineStage acquireWaitStage;

	private List<GraphicExecutionRecorderAllocation> recorders;

	private GraphicExecutionManagerAllocation(GraphicExecutionManager executionManager,
											  ProcessContext context,
											  @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation,
											  @InjectDependency(index = 1) SwapChainAllocation swapChainAllocation)
	{
		super(executionManager, context);

		final var process = (GraphicProcess) executionManager.eContainer();
		final var vkDevice = context.getVkDevice();
		imageAvailableSemaphore = new VkSemaphore(vkDevice);
		acquireWaitStage = process.getConfiguration().getAcquireWaitStage();
		executionCount = swapChainAllocation.getImageCount();
		setupRecorders(executionManager, executionCount);
		imageAcquirer = new ImageAcquirer(vkDevice,
										  imageAvailableSemaphore.getPtr(),
										  surfaceAllocation,
										  swapChainAllocation.getPtr());
	}

	@InjectChildren(index = 0, type = GraphicExecutionRecorderAllocation.class)
	private void injectRecorders(List<GraphicExecutionRecorderAllocation> recorders)
	{
		this.recorders = recorders;
	}

	@Override
	public int getExecutionCount()
	{
		return executionCount;
	}

	private static void setupRecorders(GraphicExecutionManager executionManager, int count)
	{
		final var recorders = executionManager.getRecorders();
		if (recorders.size() != count)
		{
			recorders.clear();
			for (int i = 0; i < count; i++)
			{
				final var graphicExecutionRecorder = GraphicFactory.eINSTANCE.createGraphicExecutionRecorder();
				graphicExecutionRecorder.setIndex(i);
				recorders.add(graphicExecutionRecorder);
			}
		}
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
	}

	@Override
	public IExecutionPlayer acquire()
	{
		return acquire(imageAcquirer.acquireNextImage());
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
}
