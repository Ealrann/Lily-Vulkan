package org.sheepy.lily.vulkan.api.nativehelper.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkFenceCreateInfo;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.process.IVulkanContext;
import org.sheepy.lily.vulkan.api.util.Logger;

public class VkFence implements IFence, IAllocable
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
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		device = ((IVulkanContext) context).getVkDevice();
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
	public void free(IAllocationContext context)
	{
		vkDestroyFence(device, id, null);
		id = -1;
	}

	@Override
	public boolean waitForSignal(long timeoutNs)
	{
		final int res = vkWaitForFences(device, id, true, timeoutNs);
		return res == VK_SUCCESS;
	}

	@Override
	public boolean isSignaled()
	{
		final int status = vkGetFenceStatus(device, id);
		return status == VK_SUCCESS;
	}

	@Override
	public void reset()
	{
		vkResetFences(device, id);
		used = false;
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

	@Override
	public boolean isUsed()
	{
		return used;
	}

	@Override
	public void setUsed(boolean used)
	{
		this.used = used;
	}
}