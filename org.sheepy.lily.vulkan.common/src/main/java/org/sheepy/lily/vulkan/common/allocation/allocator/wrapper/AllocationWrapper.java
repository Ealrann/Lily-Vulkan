package org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContextProvider;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationNode;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationObject;

public class AllocationWrapper extends AdapterImpl implements IAllocationWrapper
{
	private boolean allocated = false;
	private List<IAllocationWrapper> children;
	private AllocationWrapper providedContext = null;
	private final IAllocationObject allocationObject;

	AllocationWrapper(IAllocationObject allocable)
	{
		this.allocationObject = allocable;
		gatherChildWrappers();

		if (allocationObject instanceof IAllocationContextProvider)
		{
			var contextProvider = (IAllocationContextProvider) allocationObject;
			providedContext = AllocableWrapperFactory.wrap(contextProvider.getAllocationContext());
		}
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		IAllocationContext childContext = context;
		if (allocationObject instanceof IAllocationContext)
		{
			childContext = (IAllocationContext) allocationObject;
		}
		else if (providedContext != null)
		{
			providedContext.allocate(stack, context);
			childContext = (IAllocationContext) providedContext.allocationObject;
		}

		if (allocationObject instanceof IAllocable && allocated == false)
		{
			((IAllocable) allocationObject).allocate(stack, context);
			allocated = true;
		}

		for (IAllocationWrapper child : children)
		{
			child.allocate(stack, childContext);
		}
	}

	@Override
	public void free(IAllocationContext context)
	{
		freeInternal(context, false);
	}

	@Override
	public void freeDirtyElements(IAllocationContext context)
	{
		freeInternal(context, true);
	}

	private void freeInternal(IAllocationContext context, boolean onlyDirty)
	{
		IAllocationContext childContext = context;
		if (allocationObject instanceof IAllocationContext)
		{
			childContext = (IAllocationContext) allocationObject;
		}
		else if (providedContext != null)
		{
			childContext = (IAllocationContext) providedContext.allocationObject;
		}

		for (int i = children.size() - 1; i >= 0; i--)
		{
			IAllocationWrapper child = children.get(i);
			if (onlyDirty)
			{
				child.freeDirtyElements(childContext);
			}
			else
			{
				child.free(childContext);
			}
		}

		if (providedContext != null && (!onlyDirty || providedContext.isAllocationDirty(context)))
		{
			if (onlyDirty)
			{
				providedContext.freeDirtyElements(childContext);
			}
			else
			{
				providedContext.free(context);
			}
		}

		if (allocationObject instanceof IAllocable)
		{
			var allocable = (IAllocable) allocationObject;
			if (onlyDirty == false || allocable.isAllocationDirty(context))
			{
				allocable.free(context);
				allocated = false;
			}
		}
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		boolean res = false;
		if (allocationObject instanceof IAllocable)
		{
			res = ((IAllocable) allocationObject).isAllocationDirty(context);
		}

		IAllocationContext childContext = context;
		if (allocationObject instanceof IAllocationContext)
		{
			childContext = (IAllocationContext) allocationObject;
		}
		else if (providedContext != null)
		{
			childContext = (IAllocationContext) providedContext.allocationObject;
		}

		if (res == false)
		{
			if (childContext.isAllocationDirty(context))
			{
				res = true;
			}
			else
			{
				for (IAllocationWrapper child : children)
				{
					if (child.isAllocationDirty(childContext))
					{
						res = true;
						break;
					}
				}
			}
		}

		return res;
	}

	public void gatherChildWrappers()
	{
		if (allocationObject instanceof IAllocationNode)
		{
			children = new ArrayList<>();
			for (Object child : ((IAllocationNode) allocationObject).getAllocationChildren())
			{
				IAllocationWrapper wrap = AllocableWrapperFactory.wrap(child);
				if (wrap != null)
				{
					children.add(wrap);
				}
			}
		}
		else
		{
			children = Collections.emptyList();
		}
	}
}
