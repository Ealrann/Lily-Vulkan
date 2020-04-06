package org.sheepy.lily.vulkan.core.graphic;

import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

public interface IGraphicExecutionRecorders
{
	VkSemaphore getAcquireSemaphore();
}
