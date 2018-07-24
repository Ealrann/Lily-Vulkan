package org.sheepy.vulkan.pipeline.graphic;

import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.KHRSwapchain.vkQueuePresentKHR;
import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.SurfaceProcessPool;
import org.sheepy.vulkan.window.Surface;

public class GraphicProcessPool extends SurfaceProcessPool implements IAllocable, ISignalEmitter
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	public final GraphicConfiguration configuration;
	public final GraphicContext context;

	private List<GraphicProcess> processes = new ArrayList<>();

	public GraphicProcessPool(LogicalDevice logicalDevice, GraphicConfiguration configuration,
			boolean allowReset)
	{
		super(logicalDevice, logicalDevice.getQueueManager().getGraphicQueueIndex(), allowReset);

		this.configuration = configuration;

		// if (waitForSignals != null)
		// this.waitForSignals.addAll(waitForSignals);

		context = new GraphicContext(logicalDevice, commandPool, configuration, this);

		allocationObjects.add(configuration);
		allocationObjects.add(context);
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return configuration.imageAvailableSemaphore;
	}

	@Override
	public void configure(Surface surface)
	{
		context.swapChainManager.configure(surface);
		if (context.depthResource != null)
		{
			context.depthResource.configure(surface.width, surface.height);
		}
	}

	@Override
	public void resize(MemoryStack stack, Surface surface)
	{
		freeProcesses();
		configure(surface);
		allocateProcesses(stack);
		recordCommands();
	}

	private void allocateProcesses(MemoryStack stack)
	{
		configuration.allocate(stack);
		context.allocateNode(stack);
		for (GraphicProcess process : processes)
		{
			process.allocateNode(stack);
		}
	}

	private void freeProcesses()
	{
		for (GraphicProcess process : processes)
		{
			process.freeNode();
		}
		context.freeNode();
		configuration.free();
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		recordCommands();
	}

	@Override
	public void free()
	{}

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

	@Override
	public void execute()
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
