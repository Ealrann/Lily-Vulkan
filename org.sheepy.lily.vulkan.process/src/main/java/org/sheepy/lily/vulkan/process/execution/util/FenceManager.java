package org.sheepy.lily.vulkan.process.execution.util;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class FenceManager
{
	private static final String FENCE_TIMEOUT = "Fence timeout";
	private final VkFence fence;
	private final List<Consumer<EExecutionStatus>> listeners = new ArrayList<>();

	public FenceManager(VkDevice vkDevice)
	{
		fence = new VkFence(vkDevice, true);
	}

	public void free()
	{
		waitIdle();
		fence.free();
	}

	public void setUsed(boolean used)
	{
		fence.setUsed(used);
	}

	public void waitIdle()
	{
		if (fence.isUsed() && fence.isSignaled() == false)
		{
			if (fence.waitForSignal() == false)
			{
				Logger.log(FENCE_TIMEOUT, true);
			}
		}
		resetFence();
	}

	public boolean checkFence()
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

	public void resetFence()
	{
		if (fence.isUsed())
		{
			fence.reset();
			notify(EExecutionStatus.Done, true);
		}
	}

	public boolean isRunning()
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

	public VkFence getFence()
	{
		return fence;
	}

	public void start()
	{
		notify(EExecutionStatus.Started, false);
	}

	public void cancel()
	{
		notify(EExecutionStatus.Canceled, true);
	}

	private void notify(EExecutionStatus status, boolean removeListeners)
	{
		for (final var listener : listeners)
		{
			listener.accept(status);
		}
		if (removeListeners)
		{
			listeners.clear();
		}
	}

	public void addListeners(List<Consumer<EExecutionStatus>> listeners)
	{
		this.listeners.addAll(listeners);
	}

	public void addListener(Consumer<EExecutionStatus> listener)
	{
		this.listeners.add(listener);
	}
}