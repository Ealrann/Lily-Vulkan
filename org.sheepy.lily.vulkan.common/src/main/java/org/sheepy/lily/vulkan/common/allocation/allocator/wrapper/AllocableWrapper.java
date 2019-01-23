package org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.IBasicAllocable;

public class AllocableWrapper implements IAllocableWrapper
{
	private IBasicAllocable allocable;

	AllocableWrapper()
	{}

	public void set(IBasicAllocable allocable)
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
	public boolean isAllocationDirty()
	{
		return allocable.isAllocationDirty();
	}

	@Override
	public void gatherChildWrappers(AllocableWrapperPool pool,
									Collection<IAllocableWrapper> gatherIn)
	{
		var children = allocable.getChildAllocables();
		for (int i = 0; i < children.size(); i++)
		{
			var childAllocable = children.get(i);
			gatherIn.add(pool.wrap(childAllocable));
		}
	}
}