package org.sheepy.lily.vulkan.core.concurrent;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkFenceCreateInfo;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.concurrent.TimeUnit;

import static org.lwjgl.vulkan.VK10.*;

public final class VkFence implements IFenceView, IFence
{
	private static final long TIMEOUT = TimeUnit.SECONDS.toNanos(60);
	private final VkDevice vkDevice;
	private final long ptr;

	private boolean used;

	public VkFence(VkDevice vkDevice, boolean signaled)
	{
		this.vkDevice = vkDevice;
		final VkFenceCreateInfo createInfo = VkFenceCreateInfo.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_FENCE_CREATE_INFO);
		createInfo.pNext(VK_NULL_HANDLE);
		createInfo.flags(signaled ? VK_FENCE_CREATE_SIGNALED_BIT : 0);

		final long[] resArray = new long[1];
		Logger.check(vkCreateFence(vkDevice, createInfo, null, resArray), "Failed to create Fence");

		createInfo.free();
		ptr = resArray[0];
		used = signaled;
	}

	public void free()
	{
		vkDestroyFence(vkDevice, ptr, null);
	}

	public boolean waitForSignal()
	{
		return waitForSignal(TIMEOUT);
	}

	public boolean waitForSignal(long timeoutNs)
	{
		final int res = vkWaitForFences(vkDevice, ptr, true, timeoutNs);
		return res == VK_SUCCESS;
	}

	@Override
	public boolean isSignaled()
	{
		final int status = vkGetFenceStatus(vkDevice, ptr);
		return status == VK_SUCCESS;
	}

	public void reset()
	{
		vkResetFences(vkDevice, ptr);
		used = false;
	}

	public long getPtr()
	{
		return ptr;
	}

	public boolean isUsed()
	{
		return used;
	}

	public void setUsed(boolean used)
	{
		this.used = used;
	}
}
