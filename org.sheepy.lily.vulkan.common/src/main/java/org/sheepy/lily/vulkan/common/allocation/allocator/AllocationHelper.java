package org.sheepy.lily.vulkan.common.allocation.allocator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.allocator.wrapper.IAllocationWrapper;

public class AllocationHelper
{
	private final EObject target;
	private final List<IAllocationWrapper> dirtyWrappers = new ArrayList<>();

	public AllocationHelper(EObject target)
	{
		this.target = target;
	}

	public boolean isAllocationDirty()
	{
		IAllocationWrapper wrapper = getAllocationWrapper(target);
		wrapper.gatherDirtyAllocables(dirtyWrappers);
		return dirtyWrappers.isEmpty() == false;
	}

	public void reloadDirtyElements(MemoryStack stack)
	{
		for (int i = dirtyWrappers.size() - 1; i >= 0; i--)
		{
			IAllocationWrapper wrapper = dirtyWrappers.get(i);
			wrapper.free(false);
		} 

		for (int i = 0; i < dirtyWrappers.size(); i++)
		{
			IAllocationWrapper wrapper = dirtyWrappers.get(i);
			wrapper.allocate(stack, false);
		}
		dirtyWrappers.clear();
	}

	private static final IAllocationWrapper getAllocationWrapper(EObject eobject)
	{
		IAllocationWrapper res = null;

		for (Adapter adapter : eobject.eAdapters())
		{
			if (adapter instanceof IAllocationWrapper)
			{
				res = (IAllocationWrapper) adapter;
				break;
			}
		}

		return res;
	}
}
