package org.sheepy.vulkan.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

import org.lwjgl.system.MemoryStack;

// TODO la stack pourrait être conservée, jusqu'au free du node. Cela
// permettrait un reuse des objets
public abstract class AllocationNode implements IAllocationObject
{
	protected List<IAllocationObject> allocationObjects = new ArrayList<>();

	public final void allocateNode(MemoryStack stack)
	{
		Deque<IAllocable> allocatedObjects = new ArrayDeque<>();
		gatherAllocateChildren(this, allocatedObjects);

		while(allocatedObjects.isEmpty() == false)
		{
			IAllocable iAllocable = allocatedObjects.pollFirst();
			iAllocable.allocate(stack);
		}
	}

	private void gatherAllocateChildren(IAllocationObject allocationObject,
			Collection<IAllocable> allocatedObjects)			
	{
		if (allocationObject instanceof AllocationNode)
		{
			for (IAllocationObject sub : ((AllocationNode) allocationObject).allocationObjects)
			{
				gatherAllocateChildren(sub, allocatedObjects);
			}
		}

		if (allocationObject instanceof IAllocable
				&& allocatedObjects.contains((IAllocable) allocationObject) == false)
		{
			allocatedObjects.add((IAllocable) allocationObject);
		}
	}

	public final void freeNode()
	{
		Deque<IAllocable> allocatedObjects = new ArrayDeque<>();
		gatherAllocateChildren(this, allocatedObjects);
		
		while(allocatedObjects.isEmpty() == false)
		{
			IAllocable iAllocable = allocatedObjects.pollLast();
			iAllocable.free();
		}
	}
}
