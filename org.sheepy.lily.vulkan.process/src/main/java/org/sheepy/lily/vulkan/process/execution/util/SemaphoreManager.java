package org.sheepy.lily.vulkan.process.execution.util;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

import java.util.ArrayList;
import java.util.List;

public final class SemaphoreManager
{
	private final List<VkSemaphore> executionSemaphores = new ArrayList<>();
	private int semaphoreCount;
	private int borrowIndex = 0;

	public void free(VkDevice vkDevice)
	{
		executionSemaphores.forEach(s -> s.free(vkDevice));
	}

	public void next()
	{
		borrowIndex = 0;
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