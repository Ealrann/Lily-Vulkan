package org.sheepy.vulkan.barrier;

import org.lwjgl.system.NativeResource;

public interface VkBarrier<T extends NativeResource>
{
	void fill(T info);
	boolean hasChanged();
}
