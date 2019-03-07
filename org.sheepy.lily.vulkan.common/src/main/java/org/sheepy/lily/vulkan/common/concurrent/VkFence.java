package org.sheepy.lily.vulkan.common.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkFenceCreateInfo;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.device.ILogicalDeviceContext;

public class VkFence implements IFence, IAllocable
{
	private final boolean signaled;
	private long id;

	private VkDevice device;

	public VkFence(boolean signaled)
	{
		this.signaled = signaled;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		device = ((ILogicalDeviceContext) context).getVkDevice();
		VkFenceCreateInfo createInfo = VkFenceCreateInfo.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_FENCE_CREATE_INFO);
		createInfo.pNext(VK_NULL_HANDLE);
		createInfo.flags(signaled ? VK_FENCE_CREATE_SIGNALED_BIT : 0);

		long[] resArray = new long[1];
		Logger.check(vkCreateFence(device, createInfo, null, resArray), "Failed to create Fence");

		createInfo.free();
		id = resArray[0];
	}

	@Override
	public void free(IAllocationContext context)
	{
		vkDestroyFence(device, id, null);
		id = -1;
	}

	@Override
	public boolean waitForSignal(long timeoutNs)
	{
		int res = vkWaitForFences(device, id, true, timeoutNs);
		return res == VK_SUCCESS;
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

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
