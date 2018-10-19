package org.sheepy.vulkan.allocation.allocator;

import org.lwjgl.system.MemoryStack;

public interface IAllocator
{

	void allocate(MemoryStack stack);

	void free();
	
	boolean isDirty();
	
	void reloadDirtyElements(MemoryStack stack);
}
