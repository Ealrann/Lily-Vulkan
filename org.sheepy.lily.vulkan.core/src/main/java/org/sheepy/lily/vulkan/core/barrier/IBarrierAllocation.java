package org.sheepy.lily.vulkan.core.barrier;

import org.lwjgl.system.NativeResource;
import org.logoce.extender.api.IAdapter;

public interface IBarrierAllocation<T extends NativeResource> extends IAdapter
{
	void fill(T info, int index, int srcQueueIndex, int dstQueueIndex);
}
