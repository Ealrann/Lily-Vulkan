package org.sheepy.lily.vulkan.common.allocation.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationContextProvider;
import org.sheepy.vulkan.allocation.IAllocationNode;
import org.sheepy.vulkan.allocation.IAllocationObject;

public class AllocationWrapper extends AdapterImpl implements IAllocationWrapper
{
	private final IAllocationObject allocationObject;
	private final AllocationWrapper providedContext;

	private List<AllocationWrapper> children = List.of();
	private boolean allocated = false;
	private IAllocationContext childContext = null;

	AllocationWrapper(IAllocationObject allocable)
	{
		this.allocationObject = allocable;
		this.providedContext = resolveProvidedContext();
	}

	private AllocationWrapper resolveProvidedContext()
	{
		AllocationWrapper res = null;

		if (allocationObject instanceof IAllocationContextProvider)
		{
			final var contextProvider = (IAllocationContextProvider) allocationObject;
			res = AllocableWrapperFactory.INSTANCE.wrap(contextProvider.getAllocationContext());
		}

		return res;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		gatherAndAllocateChildContext(stack, context);

		if (allocated == false && allocationObject instanceof IAllocable)
		{
			((IAllocable) allocationObject).allocate(stack, context);
			allocated = true;
		}

		updateChildren();

		for (int i = 0; i < children.size(); i++)
		{
			final var child = children.get(i);
			child.allocate(stack, childContext);
		}
	}

	private void updateChildren()
	{
		final var newChildren = gatherChildWrappers();
		freeUnlinkedOldChildren(childContext, newChildren, children);
		children = newChildren;
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
			final AllocationWrapper child = children.get(i);
			child.freeInternal(childContext, onlyDirty);
		}

		if (providedContext != null && (!onlyDirty || providedContext.isAllocationDirty(context)))
		{
			providedContext.freeInternal(context, onlyDirty);
		}

		if (allocated == true && allocationObject instanceof IAllocable)
		{
			final var allocable = (IAllocable) allocationObject;
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
			if (providedContext != null && providedContext.isAllocationDirty(context))
			{
				res = true;
			}
			else
			{
				for (int i = 0; i < children.size(); i++)
				{
					final var child = children.get(i);
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

	private static void freeUnlinkedOldChildren(IAllocationContext context,
												List<AllocationWrapper> newChildren,
												List<AllocationWrapper> oldChildren)
	{
		final Set<AllocationWrapper> newChildrenSet = new HashSet<>(newChildren);

		for (final AllocationWrapper oldChild : oldChildren)
		{
			if (newChildrenSet.contains(oldChild) == false)
			{
				oldChild.freeInternal(context, false);
			}
		}
	}

	private List<AllocationWrapper> gatherChildWrappers()
	{
		List<AllocationWrapper> res = null;
		if (allocationObject instanceof IAllocationNode)
		{
			res = new ArrayList<>();
			for (final Object child : ((IAllocationNode) allocationObject).getAllocationChildren())
			{
				AllocationWrapper wrap = null;

				wrap = findChild(child);

				if (wrap == null)
				{
					wrap = AllocableWrapperFactory.INSTANCE.wrap(child);
				}

				if (wrap != null)
				{
					res.add(wrap);
				}
			}
			res = List.copyOf(res);
		}
		else
		{
			res = Collections.emptyList();
		}

		return res;
	}

	private AllocationWrapper findChild(final Object child)
	{
		AllocationWrapper res = null;

		for (final AllocationWrapper allocationWrapper : this.children)
		{
			final Object wrappedObject = child;

			if (wrappedObject == allocationWrapper.allocationObject)
			{
				res = allocationWrapper;
				break;
			}
		}
		return res;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allocationObject == null) ? 0 : allocationObject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final AllocationWrapper other = (AllocationWrapper) obj;
		if (allocationObject == null)
		{
			if (other.allocationObject != null) return false;
		}
		else if (!allocationObject.equals(other.allocationObject)) return false;
		return true;
	}
}
