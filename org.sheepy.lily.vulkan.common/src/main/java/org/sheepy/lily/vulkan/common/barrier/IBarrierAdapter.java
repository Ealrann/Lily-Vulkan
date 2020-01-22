package org.sheepy.lily.vulkan.common.barrier;

import org.lwjgl.system.NativeResource;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.barrier.VkBarrier;

public interface IBarrierAdapter<T extends NativeResource> extends IAdapter
{
	void update(int index);
	VkBarrier<T> getBackend();
}
