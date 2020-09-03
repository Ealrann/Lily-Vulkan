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
	private final String name;

	public SemaphoreManager(IVulkanContext context, String name)
	{
		this.context = context;
		this.name = name;
	}

	public VkSemaphore newSemaphore()
	{
		if (lock == true)
		{
			throw new AssertionError("Object locked, can't create a Semaphore");
		}
		final VkSemaphore res = new VkSemaphore(context.getVkDevice(), name);
		semaphores.add(res);
		semaphorePtrs.add(res.getPtr());
		return res;
	}

	public void free()
	{
		final var vkDevice = context.getVkDevice();
		for (final VkSemaphore vkSemaphore : semaphores)
		{
			vkSemaphore.free(vkDevice);
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
