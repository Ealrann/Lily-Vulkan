package org.sheepy.lily.vulkan.process.execution.util;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public final class FenceManager
{
	private static final String FENCE_TIMEOUT = "Fence timeout";
	private static final long TIMEOUT = TimeUnit.SECONDS.toNanos(60);

	private final List<FenceWrapper> fences;
	private int currentFence = -1;
	private List<Consumer<EExecutionStatus>> listeners = null;

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

	public FenceWrapper next()
	{
		currentFence = (currentFence + 1) % fences.size();
		final var res = fences.get(currentFence);
		res.waitIdle();
		assert res.listeners == null;
		res.listeners = listeners;
		res.fence.setUsed(true);
		return res;
	}

	public void waitIdle()
	{
		fences.forEach(FenceWrapper::waitIdle);
	}

	public boolean check()
	{
		boolean res = true;
		for (final var fence : fences)
		{
			res &= fence.checkFence();
		}
		return res;
	}

	public boolean isRunning()
	{
		return fences.stream().anyMatch(FenceWrapper::isRunning);
	}

	public void setNextExecutionListeners(final List<Consumer<EExecutionStatus>> listeners)
	{
		this.listeners = listeners;
	}

	public static final class FenceWrapper
	{
		public final VkFence fence;
		List<Consumer<EExecutionStatus>> listeners = null;

		FenceWrapper(VkFence fence)
		{
			this.fence = fence;
		}

		void waitIdle()
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

		boolean checkFence()
		{
			if (fence.isUsed())
			{
				if (fence.isSignaled())
				{
					resetFence();
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return true;
			}
		}

		void resetFence()
		{
			if (fence.isUsed())
			{
				fence.reset();
				notify(EExecutionStatus.Done, true);
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

		public void notify(EExecutionStatus status, boolean removeListeners)
		{
			if (listeners != null)
			{
				for (final var listener : listeners)
				{
					listener.accept(status);
				}
				if (removeListeners)
				{
					listeners = null;
				}
			}
		}
	}
}