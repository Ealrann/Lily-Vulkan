package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class FenceManager
{
	private static final String FENCE_TIMEOUT = "Fence timeout";
	private static final long TIMEOUT = TimeUnit.SECONDS.toNanos(60);

	private final List<FenceWrapper> fences;
	private int currentFence = -1;
	private List<VkFence.IFenceListener> listeners = null;

	public FenceManager(int count, VkDevice vkDevice)
	{
		final List<FenceWrapper> tmp = new ArrayList<>(count);
		for (int i = 0; i < count; i++)
		{
			final var fence = new VkFence(vkDevice, i == 0);
			final var wrapper = new FenceWrapper(fence);
			tmp.add(wrapper);
		}
		fences = List.copyOf(tmp);
	}

	public void free()
	{
		fences.forEach(FenceWrapper::free);
	}

	public VkFence next()
	{
		currentFence = (currentFence + 1) % fences.size();
		final var res = fences.get(currentFence);
		res.waitIdle();
		if (listeners != null)
		{
			res.listeners = listeners;
			listeners = null;
		}
		res.fence.setUsed(true);
		return res.fence;
	}

	public void waitIdle()
	{
		fences.forEach(FenceWrapper::waitIdle);
	}

	public void check()
	{
		fences.forEach(FenceWrapper::checkFence);
	}

	public boolean isRunning()
	{
		return fences.stream().anyMatch(FenceWrapper::isRunning);
	}

	public void setNextExecutionListeners(final List<VkFence.IFenceListener> listeners)
	{
		this.listeners = listeners;
	}

	private static final class FenceWrapper
	{
		public final VkFence fence;
		List<VkFence.IFenceListener> listeners = null;

		FenceWrapper(VkFence fence)
		{
			this.fence = fence;
		}

		void waitIdle()
		{
			if (fence != null)
			{
				if (fence.isUsed() && fence.isSignaled() == false)
				{
					if (fence.waitForSignal(TIMEOUT) == false)
					{
						Logger.log(FENCE_TIMEOUT, true);
					}
				}
				resetFence();
			}
		}

		void checkFence()
		{
			if (fence != null && fence.isUsed() && fence.isSignaled())
			{
				resetFence();
			}
		}

		void resetFence()
		{
			if (fence.isUsed())
			{
				fence.reset();
				if (listeners != null)
				{
					for (final var listener : listeners)
					{
						listener.executionDone();
					}
					listeners = null;
				}
			}
		}

		boolean isRunning()
		{
			if (fence.isUsed())
			{
				return !fence.isSignaled();
			}
			else
			{
				return false;
			}
		}

		void free()
		{
			fence.free();
		}
	}
}