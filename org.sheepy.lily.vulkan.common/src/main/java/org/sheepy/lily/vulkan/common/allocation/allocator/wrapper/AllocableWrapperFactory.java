package org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.common.allocation.IAllocationObject;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocationDescriptorAdapter;

public class AllocableWrapperFactory
{
	public static IAllocationWrapper wrap(Object object)
	{
		if (object instanceof EObject)
		{
			return wrap((EObject) object);
		}
		else if (object instanceof IAllocationDescriptorAdapter)
		{
			return wrap(((IAllocationDescriptorAdapter) object).getTarget());
		}
		else if (object instanceof IAllocationObject)
		{
			return wrap((IAllocationObject) object);
		}

		return null;
	}

	public static AllocableWrapper wrap(IAllocationObject object)
	{
		AllocableWrapper res = new AllocableWrapper();
		res.set(object);
		return res;
	}

	public static AllocationManagerAdapter wrap(EObject object)
	{
		var res = new AllocationManagerAdapter();
		object.eAdapters().add(res);
		return res;
	}
}
