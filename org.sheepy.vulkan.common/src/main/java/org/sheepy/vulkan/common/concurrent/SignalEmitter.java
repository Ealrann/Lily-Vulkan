package org.sheepy.vulkan.common.concurrent;

import org.sheepy.vulkan.api.concurrent.ISignalEmitter;
import org.sheepy.vulkan.common.device.LogicalDevice;

public class SignalEmitter implements ISignalEmitter
{
	private final LogicalDevice logicalDevice;

	private VkSemaphore semaphore = null;

	public SignalEmitter(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void free(LogicalDevice logicalDevice)
	{
		if (semaphore != null)
		{
			semaphore.free(logicalDevice);
		}
	}

	@Override
	public long getSignalSemaphore()
	{
		if (semaphore == null)
		{
			semaphore = new VkSemaphore();
			semaphore.allocate(logicalDevice);
		}
		return semaphore.getId();
	}

	@Override
	public boolean hasSemaphore()
	{
		return semaphore != null;
	}
}
