package org.sheepy.lily.vulkan.common.graphic;

import org.sheepy.vulkan.concurrent.VkSemaphore;

public interface IGraphicExecutionRecorders
{

	VkSemaphore getAcquireSemaphore();
}
