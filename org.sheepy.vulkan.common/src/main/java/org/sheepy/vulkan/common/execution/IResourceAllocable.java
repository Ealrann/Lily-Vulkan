package org.sheepy.vulkan.common.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IAllocable;

public interface IResourceAllocable extends IAllocable
{
	void allocate(MemoryStack stack, ExecutionManager executionManager);

	@Override
	default boolean isAllocationDirty()
	{
		return false;
	}
}