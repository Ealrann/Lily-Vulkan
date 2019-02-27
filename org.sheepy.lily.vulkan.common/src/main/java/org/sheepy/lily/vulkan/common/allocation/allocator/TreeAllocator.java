package org.sheepy.lily.vulkan.common.allocation.allocator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.allocator.wrapper.AllocableWrapperFactory;
import org.sheepy.lily.vulkan.common.allocation.allocator.wrapper.IAllocationWrapper;

public class TreeAllocator implements IAllocator
{
	private final EObject root;

	private IAllocationWrapper rootWrapper;
	private final List<IAllocationWrapper> dirtyWrappers = new ArrayList<>();

	private boolean isAllocated = false;

	public TreeAllocator(EObject root)
	{
		this.root = root;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		rootWrapper = AllocableWrapperFactory.wrap(root);
		rootWrapper.allocate(stack, true);
		isAllocated = true;
	}

	@Override
	public void free()
	{
		rootWrapper.free(true);
		rootWrapper = null;
		isAllocated = false;
	}

	@Override
	public boolean isAllocationDirty()
	{
		rootWrapper.gatherDirtyAllocables(dirtyWrappers);

		return dirtyWrappers.isEmpty() == false;
	}

	@Override
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

	public boolean isAllocated()
	{
		return isAllocated;
	}
}
