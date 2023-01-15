package org.sheepy.lily.vulkan.process.graphic.execution;

import org.logoce.extender.api.ModelExtender;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.graphic.IPhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.util.EVulkanErrorStatus;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicAcquirer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.IExecutionAcquirerAdapter;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.stream.Stream;

import static org.lwjgl.vulkan.KHRSwapchain.VK_SUBOPTIMAL_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

@ModelExtender(scope = GraphicAcquirer.class)
@Allocation(context = ProcessContext.class, reuseDirtyAllocations = true)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
public final class GraphicAcquirerAllocation implements IExecutionAcquirerAdapter
{
	private static final String FAILED_ACQUIRE_IMAGE = "[Acquire] Failed to acquire next image";
	private final static long TIMEOUT_NS = (long) 1e8;

	private final int executionCount;
	private final int[] nextImageArray = new int[1];
	private final VkDevice vkDevice;
	private final VkSemaphore imageAvailableSemaphore;
	private final EPipelineStage acquireWaitStage;

	private int recordIndex = -1;
	private long swapChainPtr;
	private IPhysicalSurfaceAllocation surfaceManager;

	public GraphicAcquirerAllocation(GraphicAcquirer acquirer,
									 ProcessContext context,
									 @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation,
									 @InjectDependency(index = 1) SwapChainAllocation swapChainAllocation)
	{
		final var executionManager = (GraphicExecutionManager) acquirer.eContainer();
		final var process = (GraphicProcess) executionManager.eContainer();

		this.vkDevice = context.getVkDevice();
		this.executionCount = swapChainAllocation.getImageCount();
		this.acquireWaitStage = process.getConfiguration().getAcquireWaitStage();
		this.imageAvailableSemaphore = new VkSemaphore(vkDevice, "GraphicExecutionManagerAllocation");
		this.swapChainPtr = swapChainAllocation.getPtr();
		this.surfaceManager = surfaceAllocation;
	}

	@UpdateDependency(index = 0)
	private void updateSurface(PhysicalSurfaceAllocation surfaceAllocation)
	{
		this.surfaceManager = surfaceAllocation;
	}

	@UpdateDependency(index = 1)
	private void updateSwapChain(SwapChainAllocation swapChainAllocation)
	{
		assert executionCount == swapChainAllocation.getImageCount();
		this.swapChainPtr = swapChainAllocation.getPtr();
	}

	@Free
	private void free(ProcessContext context)
	{
		final var vkDevice = context.getVkDevice();
		imageAvailableSemaphore.free(vkDevice);
	}

	@Override
	public AcquisitionInfo acquire()
	{
		recordIndex = (recordIndex + 1) % executionCount;
		final int imageIndex = acquireNextImage(imageAvailableSemaphore.getPtr());
		return new AcquisitionInfo(imageIndex, recordIndex);
	}

	private int acquireNextImage(long semaphorePtr)
	{
		final int res = vkAcquireNextImageKHR(vkDevice, swapChainPtr, TIMEOUT_NS, semaphorePtr, 0, nextImageArray);

		if (res == VK_SUCCESS || res == VK_SUBOPTIMAL_KHR) return nextImageArray[0];
		else
		{
			if (DebugUtil.DEBUG_VERBOSE_ENABLED)
			{
				Logger.check(res, FAILED_ACQUIRE_IMAGE, true);
			}
			final var status = EVulkanErrorStatus.resolveFromCode(res);
			if (status == EVulkanErrorStatus.SUBOPTIMAL_KHR || status == EVulkanErrorStatus.ERROR_SURFACE_LOST_KHR || status == EVulkanErrorStatus.ERROR_OUT_OF_DATE_KHR)
			{
				surfaceManager.setDirty();
			}
			return -1;
		}
	}

	@Override
	public Stream<WaitData> streamAcquireSemaphores()
	{
		return Stream.of(createAcquireSemaphoreData());
	}

	private WaitData createAcquireSemaphoreData()
	{
		return new WaitData(imageAvailableSemaphore, acquireWaitStage);
	}
}
