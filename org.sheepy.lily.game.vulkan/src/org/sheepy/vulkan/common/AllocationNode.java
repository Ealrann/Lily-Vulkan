package org.sheepy.vulkan.common;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import org.lwjgl.system.MemoryStack;

public abstract class AllocationNode implements IAllocationObject
{
	private final Deque<IAllocable> allocatedObjects = new ArrayDeque<>();

	public final void allocateNode(MemoryStack stack)
	{
		allocatedObjects.clear();
		gatherAllocateChildren(stack, this);
	}

	private void gatherAllocateChildren(MemoryStack stack, IAllocationObject allocationObject)
	{
		if (allocationObject instanceof AllocationNode)
		{
			for (IAllocationObject sub : ((AllocationNode) allocationObject).getSubAllocables())
			{
				gatherAllocateChildren(stack, sub);
			}
		}

		if (allocationObject instanceof IAllocable
				&& allocatedObjects.contains((IAllocable) allocationObject) == false)
		{
			allocatedObjects.add((IAllocable) allocationObject);
			((IAllocable) allocationObject).allocate(stack);
		}
	}

	public final void freeNode()
	{
		while (allocatedObjects.isEmpty() == false)
		{
			allocatedObjects.pollLast().free();
		}
	}

	protected abstract Collection<? extends IAllocationObject> getSubAllocables();
}
