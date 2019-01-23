package org.sheepy.vulkan.common.allocation.allocator.wrapper;

import java.util.ArrayDeque;
import java.util.Deque;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;

public class AllocableWrapperPool
{
	private Deque<EObjectWrapper> eObjectWrappers = new ArrayDeque<>();
	private Deque<AllocableWrapper> allocableWrappers = new ArrayDeque<>();

	public AllocableWrapperPool()
	{}

	public AllocableWrapper wrap(IBasicAllocable object)
	{
		AllocableWrapper res = null;
		if (allocableWrappers.isEmpty())
		{
			res = new AllocableWrapper();
		}
		else
		{
			res = allocableWrappers.removeLast();
		}

		res.set(object);
		return res;
	}

	public EObjectWrapper wrap(EObject object)
	{
		EObjectWrapper res = null;
		if (eObjectWrappers.isEmpty())
		{
			res = new EObjectWrapper();
		}
		else
		{
			res = eObjectWrappers.removeLast();
		}

		res.set(object);
		return res;
	}

	public void release(IAllocableWrapper wrapper)
	{
		if (wrapper instanceof EObjectWrapper)
		{
			release((EObjectWrapper) wrapper);
		}
		else if (wrapper instanceof AllocableWrapper)
		{
			release((AllocableWrapper) wrapper);
		}
	}

	public void release(EObjectWrapper wrapper)
	{
		eObjectWrappers.addLast(wrapper);
	}

	public void release(AllocableWrapper wrapper)
	{
		allocableWrappers.addLast(wrapper);
	}
}
