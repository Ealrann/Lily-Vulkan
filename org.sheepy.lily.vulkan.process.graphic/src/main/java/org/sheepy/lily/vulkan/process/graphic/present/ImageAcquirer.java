package org.sheepy.lily.vulkan.process.graphic.present;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import java.util.List;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.ISurfaceManager;
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
	public void configureAllocation(IAllocationConfiguration config, IGraphicContext context)
	{
		final var swapChainManager = context.getSwapChainManager();

		config.addDependencies(List.of(swapChainManager));
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		container = new Container(context);
	}

	@Override
	public void free(IGraphicContext context)
	{}

	public Integer acquireNextImage()
	{
		return container.acquireNextImage(nextImageArray);
	}

	private static final class Container
	{
		private final static long TIMEOUT_NS = (long) 1e8;

		private final VkSemaphore semaphore;
		private final long swapChain;
		private final ISurfaceManager surfaceManager;
		private final VkDevice device;

		private Container(IGraphicContext context)
		{
			semaphore = context.getGraphicExecutionRecorders().getAcquireSemaphore();
			swapChain = context.getSwapChainManager().getAddress();
			device = context.getVkDevice();
			surfaceManager = context.getSurfaceManager();
		}

		public Integer acquireNextImage(int[] nextImageArray)
		{
			final long semaphorePtr = semaphore.getPtr();
			final int res = vkAcquireNextImageKHR(device, swapChain, TIMEOUT_NS, semaphorePtr, 0,
					nextImageArray);

			Logger.check(res, FAILED_ACQUIRE_IMAGE, true);

			if (res == VK_SUCCESS || res == VK_SUBOPTIMAL_KHR) return nextImageArray[0];
			else
			{
				if (DebugUtil.DEBUG_ENABLED)
				{
					final var status = EVulkanErrorStatus.resolveFromCode(res);
					System.err.println("[Acquire] " + status.message);
				}
				surfaceManager.setDirty(true);
				return null;
			}
		}
	}
}
