package org.sheepy.lily.vulkan.common.allocation.wrapper;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationObject;

public final class AllocableNodeWrapper<T extends IAllocationContext> extends AdapterImpl
		implements IAllocationWrapper<T>
{
	private final Object allocableNode;

	private final AllocableWrapper<T> allocableWrapper;
	private final AllocationNodeWrapper<T> nodeWrapper;

	@SuppressWarnings("unchecked")
	AllocableNodeWrapper(Object allocableNode)
	{
		this.allocableNode = allocableNode;

		allocableWrapper = new AllocableWrapper<>((IAllocable<T>) allocableNode);
		nodeWrapper = new AllocationNodeWrapper<>((IAllocationContainer<T>) allocableNode);
	}

	@Override
	public void allocate(MemoryStack stack, T context)
	{
		allocableWrapper.allocate(stack, context);
		nodeWrapper.allocate(stack, context);
	}

	@Override
	public void free(T context)
	{
		freeInternal(context, false);
	}

	@Override
	public void freeDirtyElements(T context)
	{
		freeInternal(context, true);
	}

	@Override
	public void freeInternal(T context, boolean onlyDirty)
	{
		nodeWrapper.freeInternal(context, onlyDirty);
		allocableWrapper.freeInternal(context, onlyDirty);
	}

	@Override
	public boolean isAllocationDirty(T context)
	{
		boolean res = allocableWrapper.isAllocationDirty(context);
		if (res == false)
		{
			res = nodeWrapper.isAllocationDirty(context);
		}
		return res;
	}

	@Override
	@SuppressWarnings("unchecked")
	public IAllocationObject<T> getAllocationObject()
	{
		return (IAllocationObject<T>) allocableNode;
	}
}
