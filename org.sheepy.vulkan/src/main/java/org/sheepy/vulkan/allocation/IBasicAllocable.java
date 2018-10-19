package org.sheepy.vulkan.allocation;

import org.lwjgl.system.MemoryStack;

public interface IBasicAllocable extends IAllocable
{
	/**
	 * Children will be allocated first
	 */
	void allocate(MemoryStack stack);
}
