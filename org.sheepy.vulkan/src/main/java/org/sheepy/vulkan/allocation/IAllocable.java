package org.sheepy.vulkan.allocation;

import org.lwjgl.system.MemoryStack;

public interface IAllocable<T extends IAllocationContext> extends IAllocationObject<T>
{
	void allocate(MemoryStack stack, T context);
	void free(T context);
	boolean isAllocationDirty(T context);
}
