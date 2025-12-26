package org.sheepy.lily.vulkan.core.barrier;

import org.lwjgl.system.NativeResource;

public interface VkBarrier<T extends NativeResource>
{
	void fill(T info);
}
