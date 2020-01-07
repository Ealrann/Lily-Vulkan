package org.sheepy.vulkan.barrier;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.NativeResource;

public interface VkBarriers<T extends VkBarrier<? extends NativeResource>, Y extends NativeResource>
{
	public Y allocateInfo(MemoryStack stack);
	public abstract boolean hasChanged();
}
