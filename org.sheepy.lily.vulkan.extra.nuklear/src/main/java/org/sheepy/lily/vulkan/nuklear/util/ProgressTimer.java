package org.sheepy.lily.vulkan.nuklear.util;

import java.util.concurrent.TimeUnit;

public class ProgressTimer
{
	private final long durationNs;

	private boolean started = false;
	private long startNs = 0;
	private long endNs = 0;

	public ProgressTimer(long duration, TimeUnit unit)
	{
		this.durationNs = unit.toNanos(duration);
	}

	public void start()
	{
		startNs = System.nanoTime();
		endNs = startNs + durationNs;
		started = true;
	}

	public void stop()
	{
		started = false;
	}

	public double progress()
	{
		if(started)
		{
			if (isOverTime())
			{
				return 1d;
			}
			else
			{
				return (double) (System.nanoTime() - startNs) / durationNs;
			}
		}
		else
		{
			return 0d;
		}
	}

	public boolean isRunning()
	{
		return started;
	}

	public boolean isOverTime()
	{
		return System.nanoTime() > endNs;
	}
}
