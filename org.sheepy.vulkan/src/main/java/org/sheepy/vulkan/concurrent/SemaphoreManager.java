package org.sheepy.vulkan.concurrent;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.vulkan.device.VulkanContext;

public class SemaphoreManager
{
	private boolean lock;
	private final List<VkSemaphore> semaphores = new ArrayList<>();
	private final List<Long> semaphoreIds = new ArrayList<>();

	private final VulkanContext context;

	public SemaphoreManager(VulkanContext context)
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
		res.allocate(null, context);
		semaphores.add(res);
		semaphoreIds.add(res.getId());
		return res;
	}

	public void free()
	{
		for (final VkSemaphore vkSemaphore : semaphores)
		{
			vkSemaphore.free(context);
		}
		semaphores.clear();
		semaphoreIds.clear();
	}

	/**
	 * If lock, creation of Semaphore will be forbidden
	 * 
	 * @param value
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
		return semaphoreIds;
	}
}