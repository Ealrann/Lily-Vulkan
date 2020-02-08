package org.sheepy.lily.game.core.allocation;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.ArrayList;
import java.util.List;

public class AllocableContainer<T extends IAllocationContext> implements IAllocable<T>
{
	private final List<IAllocable<T>> allocationChildren = new ArrayList<>();

	private IAllocationConfigurator configurator;
	private boolean dirty = false;

	public AllocableContainer()
	{
	}

	public AllocableContainer(List<IAllocable<T>> allocationChildren)
	{
		this.allocationChildren.addAll(allocationChildren);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator configurator, T context)
	{
		this.configurator = configurator;
		configurator.addChildren(allocationChildren);
	}

	@Override
	public void allocate(T context)
	{
		dirty = false;
	}

	@Override
	public void free(T context)
	{}

	public void mergeChildren(List<IAllocable<T>> children)
	{
		final var oldChildren = new ArrayList<>(allocationChildren);
		allocationChildren.clear();
		allocationChildren.addAll(children);
		final var newChildren = new ArrayList<>(allocationChildren);
		newChildren.removeAll(oldChildren);
		oldChildren.removeAll(allocationChildren);
		configurator.removeChildren(oldChildren);
		configurator.addChildren(newChildren);
		configurator.setDirty();
		dirty = true;
	}

	public void addChildren(List<IAllocable<T>> newChildren)
	{
		allocationChildren.addAll(newChildren);
		if (configurator != null)
		{
			configurator.addChildren(newChildren);
			configurator.setDirty();
		}
		dirty = true;
	}

	public void removeChildren(List<IAllocable<T>> oldChildren)
	{
		allocationChildren.removeAll(oldChildren);
		if (configurator != null)
		{
			configurator.removeChildren(oldChildren);
			configurator.setDirty();
		}
		dirty = true;
	}

	public boolean isDirty()
	{
		return dirty;
	}
}
