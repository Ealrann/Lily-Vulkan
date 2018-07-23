package org.sheepy.vulkan.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import org.lwjgl.system.MemoryStack;

public abstract class AllocationNode implements IAllocationObject
{
	private final Deque<IAllocable> allocatedObjects = new ArrayDeque<>();

	protected List<IAllocationObject> allocationObjects = new ArrayList<>();

	public final void allocateNode(MemoryStack stack)
	{
		allocatedObjects.clear();
		gatherAllocateChildren(stack, this);
	}

	private void gatherAllocateChildren(MemoryStack stack, IAllocationObject allocationObject)
	{
		// TODO la stack pourrait être conservée, jusqu'au free du node. Cela
		// permettrait un reuse des objets
		if (allocationObject instanceof AllocationNode)
		{
			for (IAllocationObject sub : ((AllocationNode) allocationObject).getSubAllocables())
			{
				gatherAllocateChildren(stack, sub);
			}
			for (IAllocationObject sub : ((AllocationNode) allocationObject).allocationObjects)
			{
				gatherAllocateChildren(stack, sub);
			}
		}

		loadAllocationObject(stack, allocationObject);
	}

	protected void loadAllocationObject(MemoryStack stack, IAllocationObject allocationObject)
	{
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

	@Deprecated
	protected Collection<? extends IAllocationObject> getSubAllocables()
	{
		return Collections.emptyList();
	}

}
