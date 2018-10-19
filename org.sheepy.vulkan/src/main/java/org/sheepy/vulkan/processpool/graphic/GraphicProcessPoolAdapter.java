package org.sheepy.vulkan.processpool.graphic;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.execution.queue.EQueueType;
import org.sheepy.vulkan.execution.queue.VulkanQueue;
import org.sheepy.vulkan.model.GraphicProcessPool;
import org.sheepy.vulkan.processpool.AbstractProcessPoolAdapter;

public class GraphicProcessPoolAdapter extends AbstractProcessPoolAdapter implements ISignalEmitter
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	protected GraphicContext context;

	private VkSemaphore imageAvailableSemaphore;

	private GraphicProcessPool processPool = null;

	@Override
	protected void load()
	{
		super.load();
		this.processPool = (GraphicProcessPool) target;

		context = new GraphicContext(executionManager, resourceManager, processPool);
		childAllocables.addAll(context.getAllocationList());
	}

	@Override
	protected void unload()
	{
		childAllocables.removeAll(context.getAllocationList());
		context = null;

		this.processPool = null;
		super.unload();
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		super.deepAllocate(stack);
		recordCommands();
	}

	public void recordCommands()
	{
		context.commandBuffers.recordCommands(context);
	}

	private final int[] nextImageArray = new int[1];

	public Integer acquireNextImage()
	{
		final int res = vkAcquireNextImageKHR(context.getVkDevice(),
				context.swapChainManager.getSwapChain(), UINT64_MAX,
				imageAvailableSemaphore.getId(), VK_NULL_HANDLE, nextImageArray);

		if (res == VK_SUCCESS) return nextImageArray[0];
		else return null;
	}

	@Override
	public void execute()
	{
		final Integer imageIndex = acquireNextImage();

		if (imageIndex != null)
		{
			submitAndPresentImage(imageIndex);
		}
	}

	private void submitAndPresentImage(Integer imageIndex)
	{
		final VkQueue vkQueue = executionManager.getQueue().vkQueue;
		if (vkQueueSubmit(vkQueue, context.submission.getSubmitInfo(imageIndex),
				VK_NULL_HANDLE) != VK_SUCCESS)
		{
			System.err.println("failed to submit draw command buffer!");
		}

		if (vkQueuePresentKHR(vkQueue, context.submission.getPresentInfo(imageIndex)) != VK_SUCCESS)
		{
			System.err.println("failed to submit draw command buffer!");
		}
	}

	@Override
	public VkSemaphore newSignalSemaphore(LogicalDevice logicalDevice)
	{
		if (imageAvailableSemaphore == null)
		{
			imageAvailableSemaphore = new VkSemaphore();
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				imageAvailableSemaphore.allocate(logicalDevice);
			}
		}
		return imageAvailableSemaphore;
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.executionManager.getQueue();
	}

	@Override
	protected EQueueType getQueueType()
	{
		return EQueueType.Graphic;
	}

	public static GraphicProcessPoolAdapter adapt(GraphicProcessPool pool)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(pool, GraphicProcessPoolAdapter.class);
	}

}
