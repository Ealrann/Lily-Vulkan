package org.sheepy.lily.vulkan.common.graphic;

import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;

public interface IGraphicExecutionRecorders
{

	VkSemaphore getAcquireSemaphore();
}
