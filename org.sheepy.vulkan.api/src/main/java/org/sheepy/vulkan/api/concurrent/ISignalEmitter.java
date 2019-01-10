package org.sheepy.vulkan.api.concurrent;

public interface ISignalEmitter
{
	long getSignalSemaphore();

	boolean hasSemaphore(); 
}
