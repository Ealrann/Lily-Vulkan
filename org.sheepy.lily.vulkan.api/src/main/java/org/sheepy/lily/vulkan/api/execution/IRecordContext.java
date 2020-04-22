package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.system.MemoryStack;

public interface IRecordContext
{
	MemoryStack stack();
	int index();
}
