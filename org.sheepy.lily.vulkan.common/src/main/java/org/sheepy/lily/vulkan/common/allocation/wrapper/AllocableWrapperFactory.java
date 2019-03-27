package org.sheepy.lily.vulkan.common.allocation.wrapper;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.api.allocation.IAllocationObject;
import org.sheepy.lily.vulkan.api.allocation.adapter.IAllocationAdapter;

public class AllocableWrapperFactory
{
	public static AllocationWrapper wrap(Object object)
	{
		if (object instanceof EObject)
		{
			return wrap((EObject) object);
		}
		else if (object instanceof IAllocationObject)
		{
			return wrap((IAllocationObject) object);
		}

		return null;
	}

	public static AllocationWrapper wrap(IAllocationObject object)
	{
		final AllocationWrapper res = new AllocationWrapper(object);
		return res;
	}

	public static AllocationWrapper wrap(EObject object)
	{
		AllocationWrapper res = null;

		final var adapters = object.eAdapters();
		for (int i = 0; i < adapters.size(); i++)
		{
			final var adapter = adapters.get(i);
			if (adapter instanceof AllocationWrapper)
			{
				res = (AllocationWrapper) adapter;
				break;
			}
		}

		if (res == null)
		{
			final IAllocationAdapter adapter = IAllocationAdapter.adapt(object);

			if (adapter != null)
			{
				res = new AllocationWrapper(adapter);
				adapters.add(res);
			}
		}

		return res;
	}
}
