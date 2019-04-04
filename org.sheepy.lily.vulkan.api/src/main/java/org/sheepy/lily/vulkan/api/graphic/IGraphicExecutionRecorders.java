package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;

public interface IGraphicExecutionRecorders
{

	VkSemaphore getPresentSemaphore();
}
