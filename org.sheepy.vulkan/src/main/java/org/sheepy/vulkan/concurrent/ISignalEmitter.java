package org.sheepy.vulkan.concurrent;

import org.sheepy.vulkan.device.LogicalDevice;

public interface ISignalEmitter
{
	VkSemaphore newSignalSemaphore(LogicalDevice logicalDevice);
}
