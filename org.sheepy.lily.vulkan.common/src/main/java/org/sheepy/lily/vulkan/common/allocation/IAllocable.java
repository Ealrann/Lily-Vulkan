package org.sheepy.lily.vulkan.common.allocation;

import org.lwjgl.system.MemoryStack;

public interface IAllocable extends IAllocationObject
{
	void allocate(MemoryStack stack);
	void free();
	boolean isAllocationDirty();
}
