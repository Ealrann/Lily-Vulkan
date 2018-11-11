package org.sheepy.vulkan.common.concurrent;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.vulkan.common.device.LogicalDevice;

public class SemaphoreManager
{
	private boolean lock;
	private List<VkSemaphore> semaphores = new ArrayList<>();

	private LogicalDevice logicalDevice;

	public SemaphoreManager(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public VkSemaphore newSemaphore()
	{
		if (lock == true)
		{
			throw new AssertionError("Object locked, can't create a Semaphore");
		}
		VkSemaphore res = new VkSemaphore();
		res.allocate(logicalDevice);
		semaphores.add(res);
		return res;
	}

	public void free()
	{
		for (VkSemaphore vkSemaphore : semaphores)
		{
			vkSemaphore.free(logicalDevice);
		}
		semaphores.clear();
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

	public List<VkSemaphore> getSemaphores()
	{
		return semaphores;
	}
}
