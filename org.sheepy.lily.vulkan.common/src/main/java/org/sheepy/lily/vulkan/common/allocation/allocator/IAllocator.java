package org.sheepy.lily.vulkan.common.allocation.allocator;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;

public interface IAllocator extends IAllocable
{
	void reloadDirtyElements(MemoryStack stack);
}
