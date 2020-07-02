package org.sheepy.lily.vulkan.process.graphic.execution;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.graphic.IGraphicExecutionManager;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionConcurencyUtil;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ModelExtender(scope = GraphicExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
public final class GraphicExecutionManagerAllocation extends ExecutionManagerAllocation implements
																						IGraphicExecutionManager,
																						IExtender
{
	private final VkSemaphore imageAvailableSemaphore;
	private final ImageAcquirer imageAcquirer;
	private final List<WaitData> waitForEmitters;
	private final List<VkSemaphore> signals;
	private final int executionCount;

	private List<GraphicExecutionRecorderAllocation> recorders;

	private GraphicExecutionManagerAllocation(GraphicExecutionManager executionManager,
											  ProcessContext context,
											  @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation,
											  @InjectDependency(index = 1) SwapChainAllocation swapChainAllocation)
	{
		final var process = (GraphicProcess) executionManager.eContainer();
		imageAvailableSemaphore = new VkSemaphore(context.getVkDevice());

		executionCount = swapChainAllocation.getImageCount();
		waitForEmitters = gatherWaitDatas(process);
		signals = ExecutionConcurencyUtil.gatherSinalSemaphores(process);

		setupRecorders(executionManager, executionCount);

		imageAcquirer = new ImageAcquirer(context.getVkDevice(),
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
		imageAvailableSemaphore.free(context.getVkDevice());
	}

	@Override
	public GraphicExecutionRecorderAllocation acquire()
	{
		final Integer index = imageAcquirer.acquireNextImage();
		if (index != null)
		{
			final var recorder = recorders.get(index);
			recorder.prepare();
			return recorder;
		}
		else
		{
			return null;
		}
	}

	private List<WaitData> gatherWaitDatas(AbstractProcess process)
	{
		final var acquireWaitData = Stream.of(createAcquireSemaphoreData((GraphicProcess) process));
		final var processWaitData = ExecutionConcurencyUtil.streamWaitDatas(process);
		return Stream.concat(acquireWaitData, processWaitData).collect(Collectors.toUnmodifiableList());
	}

	private WaitData createAcquireSemaphoreData(GraphicProcess process)
	{
		final var acquireWaitStage = process.getConfiguration().getAcquireWaitStage();
		return new WaitData(imageAvailableSemaphore, acquireWaitStage);
	}

	@Override
	protected List<GraphicExecutionRecorderAllocation> getRecorders()
	{
		return recorders;
	}

	@Override
	public VkSemaphore getAcquireSemaphore()
	{
		return imageAvailableSemaphore;
	}

	public List<VkSemaphore> getSignals()
	{
		return signals;
	}

	public List<WaitData> getWaitEmitters()
	{
		return waitForEmitters;
	}
}
