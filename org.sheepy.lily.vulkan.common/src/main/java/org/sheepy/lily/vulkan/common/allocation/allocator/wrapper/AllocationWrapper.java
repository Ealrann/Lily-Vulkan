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
	private final IAllocationObject allocationObject;
	private final List<IAllocationWrapper> children;
	private final AllocationWrapper providedContext;

	private boolean allocated = false;
	private IAllocationContext childContext = null;

	AllocationWrapper(IAllocationObject allocable)
	{
		this.allocationObject = allocable;
		this.children = gatherChildWrappers();
		this.providedContext = resolveProvidedContext();
	}

	private AllocationWrapper resolveProvidedContext()
	{
		AllocationWrapper res = null;

		if (allocationObject instanceof IAllocationContextProvider)
		{
			var contextProvider = (IAllocationContextProvider) allocationObject;
			res = AllocableWrapperFactory.wrap(contextProvider.getAllocationContext());
		}

		return res;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		gatherAndAllocateChildContext(stack, context);

		if (allocationObject instanceof IAllocable && allocated == false)
		{
			((IAllocable) allocationObject).allocate(stack, context);
			allocated = true;
		}

		for (int i = 0; i < children.size(); i++)
		{
			var child = children.get(i);
			child.allocate(stack, childContext);
		}
	}

	private void gatherAndAllocateChildContext(MemoryStack stack, IAllocationContext context)
	{
		if (allocationObject instanceof IAllocationContext)
		{
			childContext = (IAllocationContext) allocationObject;
		}
		else if (providedContext != null)
		{
			providedContext.allocate(stack, context);
			childContext = (IAllocationContext) providedContext.allocationObject;
		}
		else
		{
			childContext = context;
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
			providedContext.freeInternal(context, onlyDirty);
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

		if (res == false)
		{
			if (childContext.isAllocationDirty(context))
			{
				res = true;
			}
			else
			{
				for (int i = 0; i < children.size(); i++)
				{
					var child = children.get(i);
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

	public List<IAllocationWrapper> gatherChildWrappers()
	{
		List<IAllocationWrapper> children = null;
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
			children = List.copyOf(children);
		}
		else
		{
			children = Collections.emptyList();
		}

		return children;
	}
}
