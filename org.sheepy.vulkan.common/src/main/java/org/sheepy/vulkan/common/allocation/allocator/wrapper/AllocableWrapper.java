package org.sheepy.vulkan.common.allocation.allocator.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;

public class AllocableWrapper implements IAllocableWrapper
{
	private final IBasicAllocable allocable;

	public AllocableWrapper(IBasicAllocable allocable)
	{
		this.allocable = allocable;
	}

	@Override
	public boolean isAllocable()
	{
		return true;
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		allocable.allocate(stack);
	}

	@Override
	public void free()
	{
		allocable.free();
	}

	@Override
	public boolean isDirty()
	{
		return allocable.isDirty();
	}

	@Override
	public List<IAllocableWrapper> getChildWrappers()
	{
		final List<IAllocableWrapper> res = new ArrayList<>();

		for (final IBasicAllocable childAllocable : allocable.getChildAllocables())
		{
			res.add(new AllocableWrapper(childAllocable));
		}

		return res;
	}
}