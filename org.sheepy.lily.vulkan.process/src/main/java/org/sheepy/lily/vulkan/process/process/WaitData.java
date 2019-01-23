package org.sheepy.vulkan.process.process;

import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public class WaitData
{
	public final VkSemaphore semaphore;
	public final EPipelineStage waitStage;

	public WaitData(VkSemaphore semaphore, EPipelineStage waitStage)
	{
		this.semaphore = semaphore;
		this.waitStage = waitStage;
	}
}
