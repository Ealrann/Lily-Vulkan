package org.sheepy.vulkan.pipeline.graphic;

import static org.lwjgl.vulkan.KHRSwapchain.vkAcquireNextImageKHR;
import static org.lwjgl.vulkan.KHRSwapchain.vkQueuePresentKHR;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.pipeline.Configuration;
import org.sheepy.vulkan.pipeline.Context;
import org.sheepy.vulkan.pipeline.SurfaceProcessPool;
import org.sheepy.vulkan.window.Surface;

public class GraphicProcessPool extends SurfaceProcessPool<GraphicProcess>
		implements IAllocable, ISignalEmitter
{
	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	public final GraphicConfiguration configuration;
	public final GraphicContext context;

	private VkSemaphore imageAvailableSemaphore;

	public GraphicProcessPool(GraphicConfiguration configuration, boolean allowReset)
	{
		super(configuration, configuration.logicalDevice.getQueueManager().getGraphicQueueIndex(),
				allowReset);

		this.configuration = configuration;

		// if (waitForSignals != null)
		// this.waitForSignals.addAll(waitForSignals);

		this.context = (GraphicContext) super.context;
	}

	@Override
	protected Context createContext(Configuration configuration)
	{
		return new GraphicContext(commandPool, resourceManager, descriptorPool,
				(GraphicConfiguration) configuration, this);
	}

	public GraphicProcess newGraphicProcess()
	{
		GraphicProcess res = new GraphicProcess(context);
		addProcess(res);
		return res;
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		if (imageAvailableSemaphore == null)
		{
			imageAvailableSemaphore = new VkSemaphore(logicalDevice);
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				imageAvailableSemaphore.allocate(stack);;
			}
		}
		return imageAvailableSemaphore;
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
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		recordCommands();
	}

	@Override
	public void free()
	{
		imageAvailableSemaphore.free();
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
				imageAvailableSemaphore.getId(), VK_NULL_HANDLE, nextImageArray);

		if (res == VK_SUCCESS) return nextImageArray[0];
		else return null;
	}

	@Override
	public void execute()
	{
		boolean needUpdate = false;
		for (GraphicProcess graphicProcess : processes)
		{
			needUpdate |= graphicProcess.update();
		}

		if (needUpdate)
		{
			recordCommands();
		}

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
