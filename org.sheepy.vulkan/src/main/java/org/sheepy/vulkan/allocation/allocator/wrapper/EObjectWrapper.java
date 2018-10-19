package org.sheepy.vulkan.allocation.allocator.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IBasicAllocable;
import org.sheepy.vulkan.allocation.adapter.IAllocableAdapter;
import org.sheepy.vulkan.allocation.adapter.IDeepAllocableAdapter;
import org.sheepy.vulkan.allocation.adapter.IFlatAllocableAdapter;

public class EObjectWrapper implements IAllocableWrapper
{
	private final EObject eo;

	public EObjectWrapper(EObject eo)
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
	public List<IAllocableWrapper> getChildWrappers()
	{
		final List<IAllocableWrapper> res = new ArrayList<>();
		final var adapter = getAdapter();

		for (final EObject child : eo.eContents())
		{
			res.add(new EObjectWrapper(child));
		}
		
		if (adapter != null)
		{
			for (final IBasicAllocable allocable : adapter.getChildAllocables())
			{
				res.add(new AllocableWrapper(allocable));
			}
		}

		return res;
	}
}