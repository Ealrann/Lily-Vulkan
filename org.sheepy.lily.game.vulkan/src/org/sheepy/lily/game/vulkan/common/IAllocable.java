package org.sheepy.lily.game.vulkan.common;

import org.lwjgl.system.MemoryStack;

public interface IAllocable extends IAllocationObject
{
	void allocate(MemoryStack stack);
	void free();
}
