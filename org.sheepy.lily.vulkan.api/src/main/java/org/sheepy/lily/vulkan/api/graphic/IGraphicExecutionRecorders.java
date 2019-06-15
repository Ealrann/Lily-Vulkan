package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.vulkan.concurrent.VkSemaphore;

public interface IGraphicExecutionRecorders
{

	VkSemaphore getAcquireSemaphore();
}
