package org.sheepy.lily.vulkan.common.execution;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.IBasicAllocable;

public class ResourceAllocator implements IBasicAllocable
{
	private final ExecutionManager executionManager;
	private final List<IResourceAllocable> resources;

	public ResourceAllocator(ExecutionManager executionManager, List<IResourceAllocable> resources)
	{
		this.executionManager = executionManager;
		this.resources = List.copyOf(resources);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		for (IResourceAllocable resource : resources)
		{
			resource.allocate(stack, executionManager);
		}
	}

	@Override
	public void free()
	{
		for (IResourceAllocable resource : resources)
		{
			resource.free();
		}
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
