package org.sheepy.lily.vulkan.process.execution.util;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class SynchronizationManager
{
	private final SyncUnit syncUnit;

	private final FenceManager fenceManager;

	public SynchronizationManager(VkDevice vkDevice)
	{
		fenceManager = new FenceManager(vkDevice);
		syncUnit = new SyncUnit(fenceManager);
	}

	public void free(VkDevice vkDevice)
	{
		syncUnit.free(vkDevice);
	}

	public SyncUnit next()
	{
		syncUnit.waitIdle();
		fenceManager.setUsed(true);
		return syncUnit;
	}

	public void waitIdle()
	{
		syncUnit.waitIdle();
	}

	public boolean check()
	{
		return syncUnit.checkFence();
	}

	public static final class SyncUnit
	{
		public final FenceManager fenceManager;
		private final List<VkSemaphore> executionSemaphores = new ArrayList<>();
		private int semaphoreCount;
		private int borrowIndex = 0;

		SyncUnit(FenceManager fenceManager)
		{
			this.fenceManager = fenceManager;
		}

		void waitIdle()
		{
			fenceManager.waitIdle();
		}

		boolean checkFence()
		{
			return fenceManager.checkFence();
		}

		void resetFence()
		{
			fenceManager.resetFence();
		}

		boolean isRunning()
		{
			return fenceManager.isRunning();
		}

		void free(VkDevice vkDevice)
		{
			fenceManager.free();
			executionSemaphores.forEach(s -> s.free(vkDevice));
		}

		public void start()
		{
			borrowIndex = 0;
			fenceManager.start();
		}

		public void cancel()
		{
			fenceManager.cancel();
		}

		public void setListeners(List<Consumer<EExecutionStatus>> listeners)
		{
			fenceManager.setListeners(listeners);
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

		public VkFence getFence()
		{
			return fenceManager.fence;
		}
	}
}