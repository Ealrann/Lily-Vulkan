package org.sheepy.lily.vulkan.process.graphic.execution;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.vkQueuePresentKHR;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

public class PresentSubmission
{
	private static final String FAILED_SUBMIT_PRESENT = "[Present] Failed to submit present command buffer";

	private final VkQueue presentQueue;
	private final LongBuffer bSwapChains;
	private final IntBuffer bImageIndex;
	private final VkPresentInfoKHR presentInfo;
	private final LongBuffer bPresentWaitSemaphores;

	public PresentSubmission(long swapchainPtr, VkQueue presentQueue, int imageIndex, VkSemaphore presentWaitSemaphore)
	{
		this.presentQueue = presentQueue;
		final long waitSemaphorePtr = presentWaitSemaphore.getPtr();

		bSwapChains = memAllocLong(1);
		bSwapChains.put(swapchainPtr);
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

	public void free()
	{
		presentInfo.free();
		memFree(bImageIndex);
		memFree(bSwapChains);
		memFree(bPresentWaitSemaphores);
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
}
