package org.sheepy.lily.vulkan.core.barrier;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.NativeResource;

public interface VkBarriers<T extends VkBarrier<? extends NativeResource>, Y extends NativeResource>
{
	Y allocateInfo(MemoryStack stack);
	boolean hasChanged();
}
