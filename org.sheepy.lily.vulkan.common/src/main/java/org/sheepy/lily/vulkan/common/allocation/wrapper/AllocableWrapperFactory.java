package org.sheepy.lily.vulkan.common.allocation.wrapper;

import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationContextProvider;
import org.sheepy.vulkan.allocation.IAllocationObject;
import org.sheepy.vulkan.allocation.IAllocationObject.IAllocationContainer;

public final class AllocableWrapperFactory
{
	public static final AllocableWrapperFactory INSTANCE = new AllocableWrapperFactory();

	@SuppressWarnings("unchecked")
	public <T extends IAllocationContext> IAllocationWrapper<T> wrap(IAllocationObject<T> object)
	{
		IAllocationWrapper<T> res = null;

		if (object instanceof IAllocationContextProvider)
		{
			res = createContextProvider((IAllocationContextProvider<T, ?>) object);
		}
		else if (object instanceof IAllocationContainer && object instanceof IAllocable)
		{
			res = createAllocableNode(object);
		}
		else if (object instanceof IAllocable)
		{
			res = create((IAllocable<T>) object);
		}
		else if (object instanceof IAllocationContainer)
		{
			res = create((IAllocationContainer<T>) object);
		}

		return res;
	}

	private <T extends IAllocationContext> AllocationContextProviderWrapper<T, ?> createContextProvider(IAllocationContextProvider<T, ?> object)
	{
		return new AllocationContextProviderWrapper<>(object);
	}

	private <T extends IAllocationContext> AllocableNodeWrapper<T> createAllocableNode(Object object)
	{
		return new AllocableNodeWrapper<>(object);
	}

	private <T extends IAllocationContext> AllocableWrapper<T> create(IAllocable<T> object)
	{
		return new AllocableWrapper<>(object);
	}

	private <T extends IAllocationContext> AllocationNodeWrapper<T> create(IAllocationContainer<T> object)
	{
		return new AllocationNodeWrapper<>(object);
	}
}
