package org.sheepy.lily.vulkan.api.nativehelper.concurrent;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.vulkan.api.process.IVulkanContext;

public class SemaphoreManager
{
	private boolean lock;
	private final List<VkSemaphore> semaphores = new ArrayList<>();
	private final List<Long> semaphoreIds = new ArrayList<>();

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
