package org.sheepy.lily.vulkan.common.allocation.wrapper;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationContextProvider;
import org.sheepy.vulkan.allocation.IAllocationObject;

public class AllocationContextProviderWrapper<CurrentContext extends IAllocationContext, ChildContext extends IAllocationContext>
		implements IAllocationWrapper<CurrentContext>
{
	private final IAllocationContextProvider<CurrentContext, ChildContext> contextProvider;

	private final AllocableWrapper<CurrentContext> allocableWrapper;
	private final AllocationNodeWrapper<ChildContext> nodeWrapper;

	private final ChildContext childContext;
	private final IAllocationWrapper<CurrentContext> childContextWrapper;

	@SuppressWarnings("unchecked")
	AllocationContextProviderWrapper(IAllocationContextProvider<CurrentContext, ChildContext> contextProvider)
	{
		this.contextProvider = contextProvider;

		if (contextProvider instanceof IAllocable)
		{
			allocableWrapper = new AllocableWrapper<>((IAllocable<CurrentContext>) contextProvider);
		}
		else
		{
			allocableWrapper = null;
		}

		nodeWrapper = new AllocationNodeWrapper<>(contextProvider);

		childContext = contextProvider.getAllocationContext();

		if (childContext instanceof IAllocationObject)
		{
			final var wrapper = AllocableWrapperFactory.INSTANCE
					.wrap((IAllocationObject<CurrentContext>) childContext);

			this.childContextWrapper = wrapper;
		}
		else
		{
			this.childContextWrapper = null;
		}
	}

	@Override
	public void allocate(MemoryStack stack, CurrentContext context)
	{
		if (childContextWrapper != null)
		{
			childContextWrapper.allocate(stack, context);
		}

		if (allocableWrapper != null)
		{
			allocableWrapper.allocate(stack, context);
		}
		nodeWrapper.allocate(stack, childContext);
	}

	@Override
	public void free(CurrentContext context)
	{
		freeInternal(context, false);
	}

	@Override
	public void freeDirtyElements(CurrentContext context)
	{
		freeInternal(context, true);
	}

	@Override
	public void freeInternal(CurrentContext context, boolean onlyDirty)
	{
		nodeWrapper.freeInternal(childContext, onlyDirty);

		if (childContextWrapper != null
				&& (!onlyDirty || childContextWrapper.isAllocationDirty(context)))
		{
			childContextWrapper.freeInternal(context, onlyDirty);
		}

		if (allocableWrapper != null)
		{
			allocableWrapper.freeInternal(context, onlyDirty);
		}
	}

	@Override
	public IAllocationObject<CurrentContext> getAllocationObject()
	{
		return contextProvider;
	}

	@Override
	public boolean isAllocationDirty(CurrentContext context)
	{
		boolean res = false;

		if (allocableWrapper != null)
		{
			res |= allocableWrapper.isAllocationDirty(context);
		}

		res |= (childContextWrapper != null && childContextWrapper.isAllocationDirty(context));
		res |= nodeWrapper.isAllocationDirty(childContext);

		return res;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contextProvider == null) ? 0 : contextProvider.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final var other = (AllocationContextProviderWrapper<?, ?>) obj;
		if (contextProvider == null)
		{
			if (other.contextProvider != null) return false;
		}
		else if (!contextProvider.equals(other.contextProvider)) return false;
		return true;
	}

}
