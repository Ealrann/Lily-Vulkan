package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.common.util.Logger;

public class PresentSubmission implements IAllocable<IGraphicContext>
{
	private static final String FAILED_SUBMIT_PRESENT = "[Present] Failed to submit present command buffer";

	private final int imageIndex;
	private final VkSemaphore presentWaitSemaphore;

	private LongBuffer bSwapChains;
	private IntBuffer bImageIndex;
	private VkPresentInfoKHR presentInfo;
	private LongBuffer bPresentWaitSemaphores;
	private VkQueue presentQueue;

	public PresentSubmission(int imageIndex, VkSemaphore presentWaitSemaphore)
	{
		this.presentWaitSemaphore = presentWaitSemaphore;
		this.imageIndex = imageIndex;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		config.addDependencies(List.of(context.getSwapChainManager()));
		config.addDependencies(List.of(context.getSurfaceManager()));
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var swapChain = context.getSwapChainManager();
		final long waitSemaphorePtr = presentWaitSemaphore.getPtr();

		presentQueue = context.getSurfaceManager().getPresentQueue().vkQueue;

		bSwapChains = memAllocLong(1);
		bSwapChains.put(swapChain.getAddress());
		bSwapChains.flip();

		bImageIndex = memAllocInt(1);
		bImageIndex.put(imageIndex);
		bImageIndex.flip();

		bPresentWaitSemaphores = MemoryUtil.memAllocLong(1);
		bPresentWaitSemaphores.put(waitSemaphorePtr);
		bPresentWaitSemaphores.flip();

		presentInfo = VkPresentInfoKHR.malloc();
		presentInfo.sType(VK_STRUCTURE_TYPE_PRESENT_INFO_KHR);
		presentInfo.pWaitSemaphores(bPresentWaitSemaphores);
		presentInfo.swapchainCount(1);
		presentInfo.pSwapchains(bSwapChains);
		presentInfo.pImageIndices(bImageIndex);
		presentInfo.pResults(null);
		presentInfo.pNext(VK10.VK_NULL_HANDLE);
	}

	@Override
	public void free(IGraphicContext context)
	{
		presentInfo.free();
		memFree(bImageIndex);
		memFree(bSwapChains);
		memFree(bPresentWaitSemaphores);

		presentInfo = null;
		bImageIndex = null;
		bSwapChains = null;
		bPresentWaitSemaphores = null;
	}

	public void submit()
	{
		final var res = vkQueuePresentKHR(presentQueue, presentInfo);

		if (res != VK_SUCCESS)
		{
			if (DebugUtil.DEBUG_VERBOSE_ENABLED)
			{
				Logger.check(res, FAILED_SUBMIT_PRESENT, true);
			}
		}
	}

	public VkPresentInfoKHR getPresentInfo()
	{
		return presentInfo;
	}
}
