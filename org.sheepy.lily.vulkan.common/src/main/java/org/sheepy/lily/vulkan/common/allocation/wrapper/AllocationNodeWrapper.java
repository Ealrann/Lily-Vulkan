package org.sheepy.lily.vulkan.common.allocation.wrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationObject;

public final class AllocationNodeWrapper<T extends IAllocationContext> extends AdapterImpl
		implements IAllocationWrapper<T>
{
	private final IAllocationContainer<T> allocationNode;

	private List<? extends IAllocationWrapper<? super T>> children = List.of();

	AllocationNodeWrapper(IAllocationContainer<T> allocable)
	{
		allocationNode = allocable;
	}

	@Override
	public void allocate(MemoryStack stack, T context)
	{
		updateChildren(context);

		for (int i = 0; i < children.size(); i++)
		{
			final var child = children.get(i);
			allocateChild(stack, context, child);
		}
	}

	protected void allocateChild(	MemoryStack stack,
									T context,
									final IAllocationWrapper<? super T> child)
	{
		child.allocate(stack, context);
	}

	private void updateChildren(T context)
	{
		final var newChildren = gatherChildWrappers(allocationNode.getAllocationChildren());
		freeUnlinkedOldChildren(context, newChildren, children);
		children = newChildren;
	}

	@Override
	public void free(T context)
	{
		freeInternal(context, false);
	}

	@Override
	public void freeDirtyElements(T context)
	{
		freeInternal(context, true);
	}

	@Override
	public void freeInternal(T context, boolean onlyDirty)
	{
		for (int i = children.size() - 1; i >= 0; i--)
		{
			final var child = children.get(i);
			child.freeInternal(context, onlyDirty);
		}
	}

	@Override
	public boolean isAllocationDirty(T context)
	{
		boolean res = false;
		for (int i = 0; i < children.size(); i++)
		{
			final var child = children.get(i);
			if (child.isAllocationDirty(context))
			{
				res = true;
				break;
			}
		}

		return res;
	}

	private void freeUnlinkedOldChildren(	T context,
											List<? extends IAllocationWrapper<? super T>> newChildren,
											List<? extends IAllocationWrapper<? super T>> oldChildren)
	{
		final Set<IAllocationWrapper<? super T>> newChildrenSet = new HashSet<>(newChildren);

		for (final var oldChild : oldChildren)
		{
			if (newChildrenSet.contains(oldChild) == false)
			{
				oldChild.freeInternal(context, false);
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public IAllocationObject<T> getAllocationObject()
	{
		return (IAllocationObject<T>) allocationNode;
	}

	private List<? extends IAllocationWrapper<? super T>> gatherChildWrappers(List<? extends IAllocationObject<? super T>> children)
	{
		final List<IAllocationWrapper<? super T>> res = new ArrayList<>();
		for (int i = 0; i < children.size(); i++)
		{
			final var child = children.get(i);
			final var wrap = getOrCreateChildWrapper(child);

			if (wrap != null)
			{
				res.add(wrap);
			}
		}

		return List.copyOf(res);
	}

	private IAllocationWrapper<? super T> getOrCreateChildWrapper(IAllocationObject<? super T> child)
	{
		IAllocationWrapper<? super T> res = findChild(child);

		if (res == null)
		{
			res = AllocableWrapperFactory.INSTANCE.wrap(child);
		}

		return res;
	}

	private IAllocationWrapper<? super T> findChild(final IAllocationObject<? super T> child)
	{
		IAllocationWrapper<? super T> res = null;

		for (int i = 0; i < children.size(); i++)
		{
			final var allocationWrapper = children.get(i);
			final var wrappedObject = child;

			if (wrappedObject == allocationWrapper.getAllocationObject())
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
		result = prime * result + ((allocationNode == null) ? 0 : allocationNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final AllocationNodeWrapper<?> other = (AllocationNodeWrapper<?>) obj;
		if (allocationNode == null)
		{
			if (other.allocationNode != null) return false;
		}
		else if (!allocationNode.equals(other.allocationNode)) return false;
		return true;
	}
}
