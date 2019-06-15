package org.sheepy.lily.vulkan.process.graphic.present;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.ISurfaceManager;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.log.EVulkanErrorStatus;
import org.sheepy.vulkan.log.Logger;

public class ImageAcquirer implements IAllocable<IGraphicContext>
{
	private static final String FAILED_ACQUIRE_IMAGE = "Failed to acquire next image";

	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	private final int[] nextImageArray = new int[1];

	private Container container;

	@Override
	public void allocate(MemoryStack stack, IGraphicContext context)
	{
		container = new Container(context);
	}

	@Override
	public void free(IGraphicContext context)
	{}

	@Override
	public boolean isAllocationDirty(IGraphicContext context)
	{
		return context.getSwapChainManager().isAllocationDirty(context);
	}

	public Integer acquireNextImage()
	{
		return container.acquireNextImage(nextImageArray);
	}

	private static final class Container
	{
		private final static long TIMEOUT_NS = (long) 1e8;

		private final IGraphicContext context;
		private final VkSemaphore semaphore;
		private final long swapChain;
		private final ISurfaceManager surfaceManager;
		private final VkDevice device;

		private Container(IGraphicContext context)
		{
			this.context = context;
			semaphore = context.getGraphicExecutionRecorders().getPresentSemaphore();
			swapChain = context.getSwapChainManager().getAddress();
			device = context.getVkDevice();
			surfaceManager = context.getSurfaceManager();
		}

		public Integer acquireNextImage(int[] nextImageArray)
		{
			final long semaphorePtr = semaphore.getPtr();
			final int res = vkAcquireNextImageKHR(device, swapChain, TIMEOUT_NS, semaphorePtr, 0,
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
			else
			{
				if (DebugUtil.DEBUG_ENABLED)
				{
					final var status = EVulkanErrorStatus.resolveFromCode(res);
					System.err.println(status.message);
				}
				semaphore.signalSemaphore(context);
				return null;
			}
		}
	}
}
