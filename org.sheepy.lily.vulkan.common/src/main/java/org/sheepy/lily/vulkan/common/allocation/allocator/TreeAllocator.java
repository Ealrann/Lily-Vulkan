package org.sheepy.lily.vulkan.common.allocation.allocator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.allocator.wrapper.AllocableWrapperFactory;
import org.sheepy.lily.vulkan.common.allocation.allocator.wrapper.IAllocationWrapper;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;

public class TreeAllocator implements IAllocable
{
	private final Object root;
	private IAllocationWrapper rootWrapper;
	private boolean isAllocated = false;

	public TreeAllocator(Object root)
	{
		this.root = root;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		if (rootWrapper == null)
		{
			rootWrapper = AllocableWrapperFactory.wrap(root);
		}

		rootWrapper.allocate(stack, context);
		isAllocated = true;
	}

	@Override
	public void free(IAllocationContext context)
	{
		rootWrapper.free(context);
		rootWrapper = null;
		isAllocated = false;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		if (rootWrapper == null && root instanceof EObject)
		{
			rootWrapper = getAllocationWrapper((EObject) root);
		}

		return rootWrapper.isAllocationDirty(context);
	}

	public void reloadDirtyElements(MemoryStack stack, IAllocationContext context)
	{
		if (rootWrapper == null && root instanceof EObject)
		{
			rootWrapper = getAllocationWrapper((EObject) root);
		}

		rootWrapper.freeDirtyElements(context);
		rootWrapper.allocate(stack, context);
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

	public boolean isAllocated()
	{
		return isAllocated;
	}
}
