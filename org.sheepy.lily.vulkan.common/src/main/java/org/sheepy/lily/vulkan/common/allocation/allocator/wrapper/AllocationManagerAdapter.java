package org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocationDescriptorAdapter;

public class AllocationManagerAdapter extends AdapterImpl implements IAllocationWrapper
{
	private IAllocationDescriptorAdapter allocationDescriptor;
	private List<IAllocationWrapper> children;

	@Override
	public void setTarget(Notifier newTarget)
	{
		EObject eo = (EObject) newTarget;
		allocationDescriptor = IAllocationDescriptorAdapter.adapt(eo);

		if (allocationDescriptor == null)
		{
			throw new AssertionError(String.format("Object [%s] doesn't have any %s",
					eo.eClass().getName(), IAllocationDescriptorAdapter.class.getSimpleName()));
		}

		gatherChildren();
	}

	@Override
	public void allocate(MemoryStack stack, boolean deep)
	{
		if (deep)
		{
			for (int i = 0; i < children.size(); i++)
			{
				IAllocationWrapper child = children.get(i);
				child.allocate(stack, deep);
			}
		}

		if (allocationDescriptor instanceof IAllocableAdapter)
		{
			((IAllocableAdapter) allocationDescriptor).allocate(stack);
		}
	}

	@Override
	public void free(boolean deep)
	{
		if (allocationDescriptor instanceof IAllocableAdapter)
		{
			((IAllocableAdapter) allocationDescriptor).free();
		}

		if (deep)
		{
			for (int i = children.size() - 1; i >= 0; i--)
			{
				IAllocationWrapper child = children.get(i);
				child.free(deep);
			}
		}
	}

	private void gatherChildren()
	{
		if (allocationDescriptor instanceof IAllocationDescriptorAdapter)
		{
			children = new ArrayList<>();
			for (Object child : allocationDescriptor.getAllocationList())
			{
				children.add(AllocableWrapperFactory.wrap(child));
			}
		}
		else
		{
			children = Collections.emptyList();
		}
	}

	@Override
	public void gatherDirtyAllocables(Collection<IAllocationWrapper> res)
	{
		for (IAllocationWrapper child : children)
		{
			child.gatherDirtyAllocables(res);
		}

		if (allocationDescriptor instanceof IAllocableAdapter
				&& ((IAllocableAdapter) allocationDescriptor).isAllocationDirty())
		{
			res.add(this);
		}
	}

	@Override
	public boolean isAllocable()
	{
		return allocationDescriptor instanceof IAllocableAdapter;
	}
}
