package org.sheepy.vulkan.common.allocation.allocator.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.allocation.adapter.IAllocableAdapter;
import org.sheepy.vulkan.common.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.common.allocation.adapter.IFlatAllocableAdapter;

public class EObjectWrapper implements IAllocableWrapper
{
	private EObject eo;

	EObjectWrapper()
	{}

	public void set(EObject eo)
	{
		this.eo = eo;
	}

	@Override
	public void free()
	{
		final var adapter = getAdapter();
		adapter.free();
	}

	private IAllocableAdapter getAdapter()
	{
		final var adapter = IAllocableAdapter.adapt(eo);
		return adapter;
	}

	@Override
	public boolean isDirty()
	{
		final var adapter = getAdapter();
		return adapter.isDirty();
	}

	@Override
	public boolean isAllocable()
	{
		final var adapter = getAdapter();
		return adapter != null;
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		final var adapter = getAdapter();
		if (adapter instanceof IDeepAllocableAdapter)
		{
			((IDeepAllocableAdapter) adapter).deepAllocate(stack);
		}
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final var adapter = getAdapter();
		if (adapter instanceof IFlatAllocableAdapter)
		{
			((IFlatAllocableAdapter) adapter).flatAllocate(stack);
		}
	}

	@Override
	public List<IAllocableWrapper> getChildWrappers(AllocableWrapperPool pool)
	{
		final List<IAllocableWrapper> res = new ArrayList<>();
		final var adapter = getAdapter();

		List<EObject> eContents = eo.eContents();
		for (int i = 0; i < eContents.size(); i++)
		{
			final EObject child = eContents.get(i);
			res.add(pool.wrap(child));
		}

		if (adapter != null)
		{
			List<IBasicAllocable> childAllocables = adapter.getChildAllocables();
			for (int i = 0; i < childAllocables.size(); i++)
			{
				final IBasicAllocable allocable = childAllocables.get(i);
				res.add(pool.wrap(allocable));
			}
		}

		return res;
	}
}