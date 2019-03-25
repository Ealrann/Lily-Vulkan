package org.sheepy.lily.vulkan.process.graphic.present;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class GraphicPresenter
{
	private static final String FAILED_ACQUIRE_IMAGE = "Failed to acquire next image";
	private static final String FAILED_SUBMIT_GRAPHIC = "Failed to submit graphic command buffer";
	private static final String FAILED_SUBMIT_PRESENT = "Failed to submit present command buffer";

	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	private final int[] nextImageArray = new int[1];

	private final long semaphore;
	private final long swapChain;
	private final PhysicalDeviceSurfaceManager surfaceManager;
	private final VkDevice device;
	private final VkQueue graphicQueue;
	private final VulkanQueue presentQueue;

	private final VkSubmitInfo[] submitInfos;
	private final VkPresentInfoKHR[] presentInfos;

	public GraphicPresenter(GraphicContext context, int presentCount)
	{
		semaphore = context.imageAvailableSemaphore.presentSemaphore.getId();
		swapChain = context.swapChainManager.getSwapChain();
		device = context.getVkDevice();
		surfaceManager = context.surfaceManager;

		graphicQueue = context.getQueue().vkQueue;
		presentQueue = context.surfaceManager.getPresentQueue();

		final var submission = context.frameSubmission;
		submitInfos = new VkSubmitInfo[presentCount];
		presentInfos = new VkPresentInfoKHR[presentCount];

		for (int i = 0; i < presentCount; i++)
		{
			submitInfos[i] = submission.getSubmitInfo(i);
			presentInfos[i] = submission.getPresentInfo(i);
		}
	}

	public boolean acquireNextImage()
	{
		final int res = vkAcquireNextImageKHR(device, swapChain, UINT64_MAX, semaphore, 0,
				nextImageArray);

		if (res == VK_ERROR_OUT_OF_DATE_KHR)
		{
			surfaceManager.setDirty(true);
		}
		else
		{
			Logger.check(res, FAILED_ACQUIRE_IMAGE, true);
		}

		if (res == VK_SUCCESS || res == VK_SUBOPTIMAL_KHR) return true;
		else return false;
	}

	public void submitAndPresentImage(IFence fence)
	{
		final var fenceId = fence != null ? fence.getId() : VK_NULL_HANDLE;
		final int nextImage = nextImageArray[0];
		final var submitInfo = submitInfos[nextImage];
		final var presentInfo = presentInfos[nextImage];

		Logger.check(vkQueueSubmit(graphicQueue, submitInfo, fenceId), FAILED_SUBMIT_GRAPHIC, true);

		Logger.check(vkQueuePresentKHR(presentQueue.vkQueue, presentInfo), FAILED_SUBMIT_PRESENT,
				true);
	}
}
