package org.sheepy.vulkan.common.allocation.allocator.wrapper;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IAllocable;

public interface IAllocableWrapper extends IAllocable
{
	void deepAllocate(MemoryStack stack);

	void flatAllocate(MemoryStack stack);

	boolean isAllocable();

	void gatherChildWrappers(AllocableWrapperPool pool, Collection<IAllocableWrapper> gatherIn);
}