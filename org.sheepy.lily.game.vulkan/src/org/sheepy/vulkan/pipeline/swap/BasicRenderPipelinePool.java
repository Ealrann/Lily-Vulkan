package org.sheepy.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.KHRSwapchain.vkQueuePresentKHR;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.IPipelinePool;

public class BasicRenderPipelinePool implements IPipelinePool
{
	private LogicalDevice logicalDevice;

	private CommandPool commandPool;
	private AbstractSwapPipeline swapPipeline;

	public BasicRenderPipelinePool(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			commandPool = CommandPool.alloc(stack, logicalDevice,
					logicalDevice.getQueueManager().getGraphicQueueIndex());
		}
	}

	@Override
	public void load(MemoryStack stack, long surface, int width, int height)
	{
		swapPipeline.load(surface, width, height);
	}

	@Override
	public void execute()
	{
		int imageIndex = swapPipeline.acquireNextImage();

		if (vkQueueSubmit(logicalDevice.getQueueManager().getGraphicQueue(),
				swapPipeline.getFrameSubmission().getSubmitInfo(imageIndex),
				VK_NULL_HANDLE) != VK_SUCCESS)
		{
			throw new AssertionError("failed to submit draw command buffer!");
		}

		vkQueuePresentKHR(logicalDevice.getQueueManager().getGraphicQueue(),
				swapPipeline.getFrameSubmission().getPresentInfo(imageIndex));
	}

	@Override
	public void resize(long surface, int width, int height)
	{
		swapPipeline.destroy(false);
		swapPipeline.load(surface, width, height);
	}

	@Override
	public void free()
	{
		swapPipeline.destroy(true);
		commandPool.free();
	}

	@Override
	public CommandPool getCommandPool()
	{
		return commandPool;
	}

	public void setSwapPipeline(MeshSwapPipeline swapPipeline)
	{
		this.swapPipeline = swapPipeline;
	}
}
