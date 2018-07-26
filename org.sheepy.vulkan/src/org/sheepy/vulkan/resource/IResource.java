package org.sheepy.vulkan.resource;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;

public interface IResource
{

	void allocate(MemoryStack stack, CommandPool commandPool);
	
	void free();
}
