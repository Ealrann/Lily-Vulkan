package org.sheepy.lily.vulkan.process.execution.util;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public final class SynchronizationManager
{
	private static final String FENCE_TIMEOUT = "Fence timeout";
	private static final long TIMEOUT = TimeUnit.SECONDS.toNanos(60);

	private final List<SyncUnit> syncUnits;
	private int currentIndex = -1;

	public SynchronizationManager(int count, VkDevice vkDevice)
	{
		final List<SyncUnit> tmp = new ArrayList<>(count);
		for (int i = 0; i < count; i++)
		{
			final var fence = new VkFence(vkDevice, i == 0);
			final var wrapper = new SyncUnit(fence);
			tmp.add(wrapper);
		}
		syncUnits = List.copyOf(tmp);
	}

	public void free(VkDevice vkDevice)
	{
		for (final var syncUnit : syncUnits)
		{
			syncUnit.free(vkDevice);
		}
	}

	public SyncUnit next()
	{
		currentIndex = (currentIndex + 1) % syncUnits.size();
		final var res = syncUnits.get(currentIndex);
		res.waitIdle();
		assert res.listeners == null;
		res.fence.setUsed(true);
		return res;
	}

	public void waitIdle()
	{
		syncUnits.forEach(SyncUnit::waitIdle);
	}

	public boolean check()
	{
		boolean res = true;
		for (final var fence : syncUnits)
		{
			res &= fence.checkFence();
		}
		return res;
	}

	public static final class SyncUnit
	{
		public final VkFence fence;
		private final List<VkSemaphore> executionSemaphores = new ArrayList<>();
		private List<Consumer<EExecutionStatus>> listeners = null;
		private int semaphoreCount;
		private int borrowIndex = 0;

		SyncUnit(VkFence fence)
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

		void free(VkDevice vkDevice)
		{
			waitIdle();
			fence.free();
			executionSemaphores.forEach(s -> s.free(vkDevice));
		}

		public void start()
		{
			borrowIndex = 0;
			notify(EExecutionStatus.Started, false);
		}

		public void cancel()
		{
			notify(EExecutionStatus.Canceled, true);
		}

		private void notify(EExecutionStatus status, boolean removeListeners)
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

		public void setListeners(List<Consumer<EExecutionStatus>> listeners)
		{
			this.listeners = listeners;
		}

		public void prepareSemaphores(final VkDevice vkDevice, final int semaphoreCount)
		{
			this.semaphoreCount = semaphoreCount;
			while (executionSemaphores.size() < semaphoreCount)
			{
				executionSemaphores.add(new VkSemaphore(vkDevice, "SynchronizationManager"));
			}
		}

		public List<VkSemaphore> getSemaphores()
		{
			return executionSemaphores.subList(0, semaphoreCount);
		}

		public VkSemaphore borrowSemaphore()
		{
			return getSemaphores().get(borrowIndex++);
		}
	}
}