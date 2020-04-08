package org.sheepy.lily.vulkan.core.concurrent;

import org.sheepy.lily.vulkan.core.device.IVulkanContext;

import java.util.ArrayList;
import java.util.List;

public class SemaphoreManager
{
	private boolean lock;
	private final List<VkSemaphore> semaphores = new ArrayList<>();
	private final List<Long> semaphorePtrs = new ArrayList<>();

	private final IVulkanContext context;

	public SemaphoreManager(IVulkanContext context)
	{
		this.context = context;
	}

	public VkSemaphore newSemaphore()
	{
		if (lock == true)
		{
			throw new AssertionError("Object locked, can't create a Semaphore");
		}
		final VkSemaphore res = new VkSemaphore();
		res.allocate(context);
		semaphores.add(res);
		semaphorePtrs.add(res.getPtr());
		return res;
	}

	public void free()
	{
		for (final VkSemaphore vkSemaphore : semaphores)
		{
			vkSemaphore.free(context);
		}
		semaphores.clear();
		semaphorePtrs.clear();
	}

	/**
	 * If lock, creation of Semaphore will be forbidden
	 */
	public void lock(boolean value)
	{
		this.lock = value;
	}

	public boolean isLocked()
	{
		return lock;
	}

	public List<Long> getSemaphores()
	{
		return semaphorePtrs;
	}
}
