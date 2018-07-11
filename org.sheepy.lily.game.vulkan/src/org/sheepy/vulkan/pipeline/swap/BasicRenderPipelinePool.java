package org.sheepy.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.KHRSwapchain.vkQueuePresentKHR;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.SurfacePipelinePool;
import org.sheepy.vulkan.window.Surface;

public class BasicRenderPipelinePool extends SurfacePipelinePool
{
	private LogicalDevice logicalDevice;

	private AbstractSwapPipeline swapPipeline;
	
	public BasicRenderPipelinePool(LogicalDevice logicalDevice)
	{
		super(logicalDevice, logicalDevice.getQueueManager().getGraphicQueueIndex());
		this.logicalDevice = logicalDevice;
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
	public void configure(Surface surface)
	{
		swapPipeline.configure(surface);
	}
	
	@Override
	public void resize(MemoryStack stack, Surface surface)
	{
		swapPipeline.free(false);
		configure(surface);
		swapPipeline.allocate(stack);
	}

	public void setSwapPipeline(MeshSwapPipeline swapPipeline)
	{
		this.swapPipeline = swapPipeline;
		subAllocationObjects.add(swapPipeline);
	}
}
