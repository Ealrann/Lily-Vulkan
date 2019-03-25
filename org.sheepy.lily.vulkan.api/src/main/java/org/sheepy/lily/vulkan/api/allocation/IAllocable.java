package org.sheepy.lily.vulkan.api.allocation;

import org.lwjgl.system.MemoryStack;

public interface IAllocable extends IAllocationObject
{
	void allocate(MemoryStack stack, IAllocationContext context);
	void free(IAllocationContext context);
	boolean isAllocationDirty(IAllocationContext context);
}
