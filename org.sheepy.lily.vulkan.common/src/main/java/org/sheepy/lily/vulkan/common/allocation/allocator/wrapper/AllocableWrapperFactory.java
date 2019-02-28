package org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocationAdapter;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationObject;

public class AllocableWrapperFactory
{
	public static IAllocationWrapper wrap(Object object)
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
		AllocationWrapper res = new AllocationWrapper(object);
		return res;
	}

	public static AllocationWrapper wrap(EObject object)
	{
		AllocationWrapper res = null;
		IAllocationAdapter adapter = IAllocationAdapter.adapt(object);

		if (adapter != null)
		{
			res = new AllocationWrapper(adapter);
			object.eAdapters().add(res);
		}
		return res;

	}
}
