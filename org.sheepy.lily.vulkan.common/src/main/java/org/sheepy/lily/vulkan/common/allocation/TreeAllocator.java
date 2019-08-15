package org.sheepy.lily.vulkan.common.allocation;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationManager;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.vulkan.device.IVulkanContext;

public class TreeAllocator<T extends IVulkanContext>
{
	private final IAllocationService allocationService = IAllocationService.INSTANCE;
	private final IAllocationManager<T> rootWrapper;
	private boolean isAllocated = false;
	private T context;

	public TreeAllocator(IAllocable<T> root)
	{
		rootWrapper = allocationService.register(root);
	}

	public void allocate(T context)
	{
		this.context = context;
		rootWrapper.configure(context);

		context.stackPush();
		rootWrapper.allocate();
		context.stackPop();

		isAllocated = true;
	}

	public void free()
	{
		rootWrapper.free();
		isAllocated = false;
	}

	public boolean isAllocationDirty()
	{
		return rootWrapper.isBranchDirty();
	}

	public void reloadDirtyElements()
	{
		rootWrapper.freeDirtyElements();
		context.stackPush();
		rootWrapper.allocate();
		context.stackPop();
	}

	public boolean isAllocated()
	{
		return isAllocated;
	}
}
