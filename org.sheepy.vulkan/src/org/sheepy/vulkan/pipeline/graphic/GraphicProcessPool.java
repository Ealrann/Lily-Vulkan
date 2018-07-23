package org.sheepy.vulkan.pipeline.graphic;

import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.KHRSwapchain.vkQueuePresentKHR;
import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.window.Surface;

public class GraphicProcessPool extends AllocationNode implements IAllocable, ISignalEmitter
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	public final LogicalDevice logicalDevice;
	public final CommandPool commandPool;

	public final GraphicContext context;

	public final GraphicConfiguration configuration;

	private List<GraphicProcess> processes = new ArrayList<>();

	public GraphicProcessPool(LogicalDevice logicalDevice, CommandPool commandPool,
			GraphicConfiguration configuration)
	{
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;
		this.configuration = configuration;

		// if (waitForSignals != null)
		// this.waitForSignals.addAll(waitForSignals);

		context = new GraphicContext(logicalDevice, commandPool, configuration, this);

		allocationObjects.add(context);
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return configuration.imageAvailableSemaphore;
	}

	public void configure(Surface surface)
	{
		context.swapChainManager.configure(surface);
		if (context.depthResource != null)
		{
			context.depthResource.configure(surface.width, surface.height);
		}
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		recordCommands();
	}

	public void recordCommands()
	{
		context.commandBuffers.recordCommands();
	}

	private int[] nextImageArray = new int[1];

	public Integer acquireNextImage()
	{
		int res = vkAcquireNextImageKHR(logicalDevice.getVkDevice(),
				context.swapChainManager.getSwapChain(), UINT64_MAX,
				configuration.imageAvailableSemaphore.getId(), VK_NULL_HANDLE, nextImageArray);

		if (res == VK_SUCCESS) return nextImageArray[0];
		else return null;
	}

	@Override
	public void free()
	{}

	public void addProcess(GraphicProcess process)
	{
		processes.add(process);
		process.bindContext(context);
		allocationObjects.add(process);
	}

	public List<GraphicProcess> getProcesses()
	{
		return processes;
	}

	public void exectue()
	{
		Integer imageIndex = acquireNextImage();

		if (imageIndex != null)
		{
			if (vkQueueSubmit(logicalDevice.getQueueManager().getGraphicQueue(),
					context.submission.getSubmitInfo(imageIndex), VK_NULL_HANDLE) != VK_SUCCESS)
			{
				throw new AssertionError("failed to submit draw command buffer!");
			}

			if (vkQueuePresentKHR(logicalDevice.getQueueManager().getGraphicQueue(),
					context.submission.getPresentInfo(imageIndex)) != VK_SUCCESS)
			{
				throw new AssertionError("failed to submit draw command buffer!");
			}
		}
	}
}
