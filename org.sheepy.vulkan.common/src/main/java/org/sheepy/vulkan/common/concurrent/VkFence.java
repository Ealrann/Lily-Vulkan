package org.sheepy.vulkan.common.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkFenceCreateInfo;
import org.sheepy.vulkan.api.concurrent.IFence;
import org.sheepy.vulkan.common.util.Logger;

public class VkFence implements IFence
{
	private final VkDevice device;

	private long id;

	public VkFence(VkDevice device)
	{
		this.device = device;
	}

	public void allocate()
	{
		VkFenceCreateInfo createInfo = VkFenceCreateInfo.calloc();
		createInfo.set(VK_STRUCTURE_TYPE_FENCE_CREATE_INFO, VK_NULL_HANDLE, 0);

		long[] resArray = new long[1];
		Logger.check(vkCreateFence(device, createInfo, null, resArray), "Failed to create Fence");

		id = resArray[0];
	}

	public void free()
	{
		vkDestroyFence(device, id, null);
	}

	@Override
	public boolean isSignaled()
	{
		int status = vkGetFenceStatus(device, id);
		return status == VK_SUCCESS;
	}

	@Override
	public void reset()
	{
		vkResetFences(device, id);
	}

	@Override
	public long getId()
	{
		return id;
	}
}
