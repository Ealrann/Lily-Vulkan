package org.sheepy.lily.vulkan.common.resource;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.execution.IResourceAllocable;

public class ResourceAllocator implements IAllocable
{
	private final ExecutionContext execution;
	private final IResourceAllocable resource;

	public ResourceAllocator(ExecutionContext execution, IResourceAllocable resource)
	{
		this.execution = execution;
		this.resource = resource;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		resource.allocate(stack, execution);
	}

	@Override
	public void free()
	{
		resource.free();
	}

	@Override
	public boolean isAllocationDirty()
	{
		return resource.isAllocationDirty();
	}
}
