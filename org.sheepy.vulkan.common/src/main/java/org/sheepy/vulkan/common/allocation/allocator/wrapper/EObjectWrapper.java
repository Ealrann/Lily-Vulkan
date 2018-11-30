package org.sheepy.vulkan.common.allocation.allocator.wrapper;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.adapter.IAllocableAdapter;
import org.sheepy.vulkan.common.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.common.allocation.adapter.IFlatAllocableAdapter;

public class EObjectWrapper implements IAllocableWrapper
{
	private EObject eo;
	private IAllocableAdapter adapter;

	EObjectWrapper()
	{}

	public void set(EObject eo)
	{
		this.eo = eo;
		adapter = IAllocableAdapter.adapt(eo);
	}

	@Override
	public void free()
	{
		adapter.free();
	}

	@Override
	public boolean isAllocationDirty()
	{
		return adapter.isAllocationDirty();
	}

	@Override
	public boolean isAllocable()
	{
		return adapter != null;
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		if (adapter instanceof IDeepAllocableAdapter)
		{
			((IDeepAllocableAdapter) adapter).deepAllocate(stack);
		}
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		if (adapter instanceof IFlatAllocableAdapter)
		{
			((IFlatAllocableAdapter) adapter).flatAllocate(stack);
		}
	}

	@Override
	public void gatherChildWrappers(AllocableWrapperPool pool,
									Collection<IAllocableWrapper> gatherIn)
	{
		gatherChildEObjects(pool, gatherIn);
		gatherChildAllocables(pool, gatherIn);
	}

	private void gatherChildAllocables(	AllocableWrapperPool pool,
										Collection<IAllocableWrapper> gatherIn)
	{
		if (adapter != null)
		{
			var childAllocables = adapter.getChildAllocables();
			for (int i = 0; i < childAllocables.size(); i++)
			{
				var allocable = childAllocables.get(i);
				gatherIn.add(pool.wrap(allocable));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void gatherChildEObjects(	AllocableWrapperPool pool,
										Collection<IAllocableWrapper> gatherIn)
	{
		var containments = eo.eClass().getEAllContainments();
		for (int i = 0; i < containments.size(); i++)
		{
			var eReference = containments.get(i);
			if (eReference.isMany())
			{
				var values = (List<EObject>) eo.eGet(eReference);
				for (int j = 0; j < values.size(); j++)
				{
					EObject value = values.get(j);
					if (value != null)
					{
						gatherIn.add(pool.wrap(value));
					}
				}
			}
			else
			{
				var value = (EObject) eo.eGet(eReference);
				if (value != null)
				{
					gatherIn.add(pool.wrap(value));
				}
			}
		}
	}
}