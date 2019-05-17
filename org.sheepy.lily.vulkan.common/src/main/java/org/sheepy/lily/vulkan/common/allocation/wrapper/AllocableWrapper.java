package org.sheepy.lily.vulkan.common.allocation.wrapper;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationObject;

public class AllocableWrapper<T extends IAllocationContext> extends AdapterImpl
		implements IAllocationWrapper<T>
{
	protected final IAllocable<T> allocable;

	protected boolean allocated = false;

	AllocableWrapper(IAllocable<T> allocable)
	{
		this.allocable = allocable;
	}

	@Override
	public void allocate(MemoryStack stack, T context)
	{
		if (allocated == false)
		{
			allocable.allocate(stack, context);
			allocated = true;
		}
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
		if (allocated == true)
		{
			if (onlyDirty == false || allocable.isAllocationDirty(context))
			{
				allocable.free(context);
				allocated = false;
			}
		}
	}

	@Override
	public IAllocationObject<T> getAllocationObject()
	{
		return allocable;
	}

	@Override
	public boolean isAllocationDirty(T context)
	{
		return allocable.isAllocationDirty(context);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allocable == null) ? 0 : allocable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final AllocableWrapper<?> other = (AllocableWrapper<?>) obj;
		if (allocable == null)
		{
			if (other.allocable != null) return false;
		}
		else if (!allocable.equals(other.allocable)) return false;
		return true;
	}
}
