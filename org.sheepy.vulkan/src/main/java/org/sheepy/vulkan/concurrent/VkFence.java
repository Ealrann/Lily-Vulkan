package org.sheepy.vulkan.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkFenceCreateInfo;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.log.Logger;

public class VkFence implements IAllocable<IVulkanContext>
{
	private final boolean signaled;
	private long id;

	private boolean used = false;
	private VkDevice device;

	public VkFence(boolean signaled)
	{
		this.signaled = signaled;
	}

	@Override
	public void allocate(IVulkanContext context)
	{
		device = context.getVkDevice();
		final VkFenceCreateInfo createInfo = VkFenceCreateInfo.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_FENCE_CREATE_INFO);
		createInfo.pNext(VK_NULL_HANDLE);
		createInfo.flags(signaled ? VK_FENCE_CREATE_SIGNALED_BIT : 0);

		final long[] resArray = new long[1];
		Logger.check(vkCreateFence(device, createInfo, null, resArray), "Failed to create Fence");

		createInfo.free();
		id = resArray[0];
		used = false;
	}

	@Override
	public void free(IVulkanContext context)
	{
		vkDestroyFence(device, id, null);
		id = -1;
	}

	public boolean waitForSignal(long timeoutNs)
	{
		final int res = vkWaitForFences(device, id, true, timeoutNs);
		return res == VK_SUCCESS;
	}

	public boolean isSignaled()
	{
		final int status = vkGetFenceStatus(device, id);
		return status == VK_SUCCESS;
	}

	public void reset()
	{
		vkResetFences(device, id);
		used = false;
	}

	public long getId()
	{
		return id;
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
