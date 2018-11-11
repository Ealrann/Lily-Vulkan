package org.sheepy.vulkan.common.allocation.allocator;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IAllocable;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;

/**
 * 
 * Doit couvrir le cas des enfants (getChildAllocables()) pour etre utilisable
 * 
 * @author ealrann
 *
 */
@Deprecated
public class AllocationList implements IAllocator
{
	private final List<IBasicAllocable> allocables = new ArrayList<>();

	public AllocationList()
	{}

	public void add(IBasicAllocable allocable)
	{
		allocables.add(allocable);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		for (final IBasicAllocable allocable : allocables)
		{
			allocable.allocate(stack);
		}
	}

	@Override
	public void free()
	{
		for (final IAllocable allocable : allocables)
		{
			allocable.free();
		}
	}

	@Override
	public boolean isDirty()
	{
		for (final IAllocable allocable : allocables)
		{
			if (allocable.isDirty())
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public void reloadDirtyElements(MemoryStack stack)
	{
		for (final IBasicAllocable allocable : allocables)
		{
			if (allocable.isDirty())
			{
				allocable.free();
				allocable.allocate(stack);
			}
		}
	}

	public void clear()
	{
		allocables.clear();
	}
}
