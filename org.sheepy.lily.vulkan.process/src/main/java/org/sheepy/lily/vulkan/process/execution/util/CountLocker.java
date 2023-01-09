package org.sheepy.lily.vulkan.process.execution.util;

/**
 * Lock when count > 0
 */
public final class CountLocker
{
	private final Runnable onLock;
	private final Runnable onUnlock;
	private int count = 0;

	public CountLocker(Runnable onLock, Runnable onUnlock)
	{
		this.onLock = onLock;
		this.onUnlock = onUnlock;
	}

	public void increase()
	{
		count++;
		if (count == 1)
		{
			onLock.run();
		}
	}

	public void decrease()
	{
		assert count > 0;
		count--;
		if (count == 0)
		{
			onUnlock.run();
		}
	}
}