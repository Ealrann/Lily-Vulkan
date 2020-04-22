package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public record WaitData(VkSemaphore semaphore, EPipelineStage waitStage)
{
}
