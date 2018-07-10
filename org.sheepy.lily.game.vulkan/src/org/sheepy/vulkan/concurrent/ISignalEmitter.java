package org.sheepy.vulkan.concurrent;

public interface ISignalEmitter
{

	VkSemaphore newSignalSemaphore();
}
