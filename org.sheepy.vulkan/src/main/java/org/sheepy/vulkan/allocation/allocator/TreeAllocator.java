package org.sheepy.vulkan.allocation.allocator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.allocator.wrapper.EObjectWrapper;
import org.sheepy.vulkan.allocation.allocator.wrapper.IAllocableWrapper;

public class TreeAllocator implements IAllocator
{
	private final EObject root;

	private final Deque<IAllocableWrapper> gatheredAllocables = new ArrayDeque<>();

	private Deque<IAllocableWrapper> course = new ArrayDeque<>();
	private Deque<IAllocableWrapper> nextCourse = new ArrayDeque<>();

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
		gatheredAllocables.clear();
		nextCourse.add(new EObjectWrapper(root));
		while (nextCourse.isEmpty() == false)
		{
			swapCourseQueues();
			while (course.isEmpty() == false)
			{
				gatherElement(course.pop(), onlyDirty);
			}
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
		if (element.isAllocable())
		{
			if (!onlyDirty || element.isDirty())
			{
				gatheredAllocables.addLast(element);
			}
		}
		nextCourse.addAll(element.getChildWrappers());
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
		while (gatheredAllocables.isEmpty() == false)
		{
			final IAllocableWrapper wrapper = gatheredAllocables.pollLast();
			wrapper.deepAllocate(stack);
		}
	}

	@Override
	public void free()
	{
		gatherFlatTree(false);

		deepFreeAndRemove();
	}

	private void deepFreeAndRemove()
	{
		while (gatheredAllocables.isEmpty() == false)
		{
			final IAllocableWrapper next = gatheredAllocables.peekLast();
			next.free();
		}
	}

	private void deepFree()
	{
		final Iterator<IAllocableWrapper> it = gatheredAllocables.descendingIterator();
		
		while (it.hasNext())
		{
			final IAllocableWrapper next = it.next();
			next.free();
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
