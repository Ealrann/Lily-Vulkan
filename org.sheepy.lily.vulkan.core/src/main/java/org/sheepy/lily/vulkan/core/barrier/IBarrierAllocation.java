package org.sheepy.lily.vulkan.core.barrier;

import org.lwjgl.system.NativeResource;
import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.execution.RecordContext;

public interface IBarrierAllocation<T extends NativeResource> extends IAdapter
{
	void fill(T info, RecordContext recordContext, int srcQueueIndex, int dstQueueIndex);
}
