package org.sheepy.vulkan.common.allocation.allocator.wrapper;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IAllocable;

public interface IAllocableWrapper extends IAllocable
{
	void deepAllocate(MemoryStack stack);

	void flatAllocate(MemoryStack stack);

	boolean isAllocable();

	List<IAllocableWrapper> getChildWrappers(AllocableWrapperPool pool);
}