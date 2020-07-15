package org.sheepy.lily.vulkan.process.graphic.execution;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.graphic.IPhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.core.util.EVulkanErrorStatus;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;

import static org.lwjgl.vulkan.KHRSwapchain.VK_SUBOPTIMAL_KHR;
import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

public final class ImageAcquirer
{
	private static final String FAILED_ACQUIRE_IMAGE = "[Acquire] Failed to acquire next image";
	private final static long TIMEOUT_NS = (long) 1e8;

	private final int[] nextImageArray = new int[1];
	private final VkDevice vkDevice;
	private final long semaphorePtr;

	private long swapChainPtr;
	private IPhysicalSurfaceAllocation surfaceManager;

	public ImageAcquirer(VkDevice vkDevice,
						 long semaphorePtr,
						 PhysicalSurfaceAllocation surfaceAllocation,
						 long swapChainPtr)
	{
		this.semaphorePtr = semaphorePtr;
		this.swapChainPtr = swapChainPtr;
		this.vkDevice = vkDevice;
		this.surfaceManager = surfaceAllocation;
	}

	public int acquireNextImage()
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

	public void updateSurface(final PhysicalSurfaceAllocation surfaceAllocation)
	{
		this.surfaceManager = surfaceAllocation;
	}

	public void updateSwapChain(long swapChainPtr)
	{
		this.swapChainPtr = swapChainPtr;
	}
}
