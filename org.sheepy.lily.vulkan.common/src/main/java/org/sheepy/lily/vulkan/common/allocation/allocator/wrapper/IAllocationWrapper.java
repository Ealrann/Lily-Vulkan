package org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;

public interface IAllocationWrapper
{
	void allocate(MemoryStack stack, boolean deep);

	void free(boolean deep);

	public void gatherDirtyAllocables(Collection<IAllocationWrapper> res);

	boolean isAllocable();
}
