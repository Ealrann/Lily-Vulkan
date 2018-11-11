package org.sheepy.vulkan.common.concurrent;

import org.sheepy.vulkan.common.device.LogicalDevice;

public interface ISignalEmitter
{
	VkSemaphore newSignalSemaphore(LogicalDevice logicalDevice);
}
