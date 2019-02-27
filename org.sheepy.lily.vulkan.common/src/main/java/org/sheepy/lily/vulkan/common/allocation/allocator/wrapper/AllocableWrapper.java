package org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.IAllocationNode;
import org.sheepy.lily.vulkan.common.allocation.IAllocationObject;

public class AllocableWrapper implements IAllocationWrapper
{
	private IAllocationObject allocationObject;
	private List<IAllocationWrapper> children;

	AllocableWrapper()
	{}

	public void set(IAllocationObject allocable)
	{
		this.allocationObject = allocable;
		gatherChildWrappers();
	}

	public void unset()
	{
		allocationObject = null;
		children = null;
	}

	@Override
	public boolean isAllocable()
	{
		return allocationObject instanceof IAllocable;
	}

	@Override
	public void allocate(MemoryStack stack, boolean deep)
	{
		if (deep)
		{
			for (IAllocationWrapper child : children)
			{
				child.allocate(stack, deep);
			}
		}

		if (allocationObject instanceof IAllocable)
		{
			((IAllocable) allocationObject).allocate(stack);
		}
	}

	@Override
	public void free(boolean deep)
	{
		if (allocationObject instanceof IAllocable)
		{
			((IAllocable) allocationObject).free();
		}

		if (deep)
		{
			for (IAllocationWrapper child : children)
			{
				child.free(deep);
			}
		}
	}

	@Override
	public void gatherDirtyAllocables(Collection<IAllocationWrapper> res)
	{
		for (IAllocationWrapper child : children)
		{
			child.gatherDirtyAllocables(res);
		}

		if (isAllocationDirty())
		{
			res.add(this);
		}
	}

	public boolean isAllocationDirty()
	{
		if (allocationObject instanceof IAllocable)
		{
			return ((IAllocable) allocationObject).isAllocationDirty();
		}
		else
		{
			return false;
		}
	}

	public void gatherChildWrappers()
	{
		if (allocationObject instanceof IAllocationNode)
		{
			children = new ArrayList<>();
			for (Object child : ((IAllocationNode) allocationObject).getAllocationList())
			{
				children.add(AllocableWrapperFactory.wrap(child));
			}
		}
		else
		{
			children = Collections.emptyList();
		}
	}
}