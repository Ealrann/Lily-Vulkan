package org.sheepy.vulkan.common.allocation.allocator;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;

public interface IAllocator extends IBasicAllocable
{
	void reloadDirtyElements(MemoryStack stack);
}
