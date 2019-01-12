package org.sheepy.vulkan.api.concurrent;

public interface IFence
{
	boolean isSignaled();
	
	void reset();
	
	long getId();
}
