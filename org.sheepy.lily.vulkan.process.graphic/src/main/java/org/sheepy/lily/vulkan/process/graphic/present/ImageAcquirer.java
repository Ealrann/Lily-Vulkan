package org.sheepy.lily.vulkan.process.graphic.present;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class ImageAcquirer implements IAllocable
{
	private static final String FAILED_ACQUIRE_IMAGE = "Failed to acquire next image";

	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	private final int[] nextImageArray = new int[1];

	private Container container;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		container = new Container(graphicContext);
	}

	@Override
	public void free(IAllocationContext context)
	{}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		return graphicContext.swapChainManager.isAllocationDirty(context);
	}

	public Integer acquireNextImage()
	{
		return container.acquireNextImage();
	}

	class Container
	{
		final long semaphore;
		final long swapChain;
		final PhysicalDeviceSurfaceManager surfaceManager;
		final VkDevice device;

		Container(GraphicContext context)
		{
			semaphore = context.executionRecorders.imageAvailableSemaphore.presentSemaphore.getId();
			swapChain = context.swapChainManager.getSwapChain();
			device = context.getVkDevice();
			surfaceManager = context.surfaceManager;
		}

		public Integer acquireNextImage()
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

			if (res == VK_SUCCESS || res == VK_SUBOPTIMAL_KHR) return nextImageArray[0];
			else return null;
		}
	}

}
