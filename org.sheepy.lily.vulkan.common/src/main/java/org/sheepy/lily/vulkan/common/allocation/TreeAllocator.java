package org.sheepy.lily.vulkan.common.allocation;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocationAdapter;
import org.sheepy.lily.vulkan.common.allocation.wrapper.AllocableWrapperFactory;
import org.sheepy.lily.vulkan.common.allocation.wrapper.IAllocationWrapper;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationObject;

public class TreeAllocator<T extends IAllocationContext> implements IAllocable<T>
{
	private final IAllocationWrapper<T> rootWrapper;
	private boolean isAllocated = false;

	public TreeAllocator(IAllocationObject<T> root)
	{
		rootWrapper = AllocableWrapperFactory.INSTANCE.wrap(root);
		if (rootWrapper == null)
		{
			throw new AssertionError(String.format("[%s] cannot be adapted to %s.",
					rootWrapper.getClass().getSimpleName(),
					IAllocationAdapter.class.getSimpleName()));
		}
	}

	@Override
	public void allocate(MemoryStack stack, T context)
	{
		rootWrapper.allocate(stack, context);
		isAllocated = true;
	}

	@Override
	public void free(T context)
	{
		rootWrapper.free(context);
		isAllocated = false;
	}

	@Override
	public boolean isAllocationDirty(T context)
	{
		return rootWrapper.isAllocationDirty(context);
	}

	public void reloadDirtyElements(MemoryStack stack, T context)
	{
		rootWrapper.freeDirtyElements(context);
		rootWrapper.allocate(stack, context);
	}

	public boolean isAllocated()
	{
		return isAllocated;
	}
}
