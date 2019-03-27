package org.sheepy.lily.vulkan.api.concurrent;

public interface IFence
{
	boolean isUsed();

	void setUsed(boolean used);

	boolean isSignaled();

	boolean waitForSignal(long timeoutNs);

	void reset();

	long getId();
}
