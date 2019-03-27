package org.sheepy.lily.vulkan.process.graphic.api;

import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;

public interface IGraphicExecutionRecorders
{

	VkSemaphore getPresentSemaphore();
}
