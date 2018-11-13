package org.sheepy.vulkan.common.allocation.allocator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.allocator.wrapper.AllocableWrapperPool;
import org.sheepy.vulkan.common.allocation.allocator.wrapper.IAllocableWrapper;

public class TreeAllocator implements IAllocator
{
	private final EObject root;

	private final List<IAllocableWrapper> gatheredAllocables = new ArrayList<>();

	private Deque<IAllocableWrapper> course = new ArrayDeque<>();
	private Deque<IAllocableWrapper> nextCourse = new ArrayDeque<>();

	private AllocableWrapperPool pool = new AllocableWrapperPool();

	public TreeAllocator(EObject root)
	{
		this.root = root;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		gatherFlatTree(false);

		flatAllocateGatheredObjects(stack);
		deepAllocateGatheredObjects(stack);
	}

	private void gatherFlatTree(boolean onlyDirty)
	{
		clean();
		nextCourse.add(pool.wrap(root));
		while (nextCourse.isEmpty() == false)
		{
			swapCourseQueues();
			while (course.isEmpty() == false)
			{
				gatherElement(course.pop(), onlyDirty);
			}
		}
	}

	private void clean()
	{
		if (gatheredAllocables.isEmpty() == false)
		{
			for (int i = 0; i < gatheredAllocables.size(); i++)
			{
				IAllocableWrapper wrapper = gatheredAllocables.get(i);
				pool.release(wrapper);
			}
			gatheredAllocables.clear();
		}
	}

	private void swapCourseQueues()
	{
		final var oldCourse = course;
		course = nextCourse;
		nextCourse = oldCourse;
	}

	private void gatherElement(IAllocableWrapper element, boolean onlyDirty)
	{
		boolean gathered = false;
		if (element.isAllocable())
		{
			if (!onlyDirty || element.isDirty())
			{
				gatheredAllocables.add(element);
				gathered = true;
			}
		}

		element.gatherChildWrappers(pool, nextCourse);

		if (gathered == false)
		{
			pool.release(element);
		}
	}

	private void flatAllocateGatheredObjects(MemoryStack stack)
	{
		for (final IAllocableWrapper wrapper : gatheredAllocables)
		{
			wrapper.flatAllocate(stack);
		}
	}

	private void deepAllocateGatheredObjects(MemoryStack stack)
	{
		for (int i = gatheredAllocables.size() - 1; i >= 0; i--)
		{
			IAllocableWrapper wrapper = gatheredAllocables.get(i);
			wrapper.deepAllocate(stack);
			pool.release(wrapper);
		}
		gatheredAllocables.clear();
	}

	@Override
	public void free()
	{
		gatherFlatTree(false);

		deepFreeAndRemove();
	}

	private void deepFreeAndRemove()
	{
		for (int i = gatheredAllocables.size() - 1; i >= 0; i--)
		{
			IAllocableWrapper wrapper = gatheredAllocables.get(i);
			wrapper.free();
			pool.release(wrapper);
		}
		gatheredAllocables.clear();
	}

	private void deepFree()
	{
		for (int i = gatheredAllocables.size() - 1; i > 0; i--)
		{
			IAllocableWrapper wrapper = gatheredAllocables.get(i);
			wrapper.free();
		}
	}

	@Override
	public boolean isDirty()
	{
		gatherFlatTree(true);
		return gatheredAllocables.isEmpty() == false;
	}

	@Override
	public void reloadDirtyElements(MemoryStack stack)
	{
		deepFree();

		flatAllocateGatheredObjects(stack);
		deepAllocateGatheredObjects(stack);
	}
}
