package org.sheepy.lily.vulkan.core.barrier;

import org.lwjgl.system.NativeResource;
import org.sheepy.lily.core.api.extender.IExtender;

public interface IBarrierAllocation<T extends NativeResource> extends IExtender
{
	void fill(T info, int index, int srcQueueIndex, int dstQueueIndex);
}
