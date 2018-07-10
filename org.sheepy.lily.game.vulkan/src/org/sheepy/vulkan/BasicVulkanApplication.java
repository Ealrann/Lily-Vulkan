package org.sheepy.vulkan;

import static org.lwjgl.vulkan.VK10.vkQueueWaitIdle;

import org.sheepy.vulkan.pipeline.IPipelinePool;

public class BasicVulkanApplication extends VulkanApplication
{
	public BasicVulkanApplication(int width, int height)
	{
		super(width, height);
	}

	@Override
	public void drawFrame()
	{
		vkQueueWaitIdle(logicalDevice.getQueueManager().getPresentQueue());

		for (IPipelinePool iPipelinePool : pipelinePools)
		{
			iPipelinePool.execute();
		}
	}
}
