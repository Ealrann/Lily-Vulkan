package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.system.MemoryStack;

public interface IResourceAllocable
{
	void allocate(MemoryStack stack, ExecutionContext executionManager);

	void free();

	default boolean isAllocationDirty()
	{
		return false;
	}
}
