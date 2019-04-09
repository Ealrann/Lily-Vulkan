package org.sheepy.lily.vulkan.common.allocation;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.allocation.adapter.IAllocationAdapter;
import org.sheepy.lily.vulkan.common.allocation.wrapper.AllocableWrapperFactory;
import org.sheepy.lily.vulkan.common.allocation.wrapper.IAllocationWrapper;

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
			rootWrapper = AllocableWrapperFactory.INSTANCE.wrap(root);

			if (rootWrapper == null)
			{
				throw new AssertionError(String.format("[%s] cannot be adapted to %s.",
						rootWrapper.getClass().getSimpleName(),
						IAllocationAdapter.class.getSimpleName()));
			}
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

		for (final Adapter adapter : eobject.eAdapters())
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
