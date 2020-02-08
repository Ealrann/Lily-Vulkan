package org.sheepy.lily.vulkan.core.barrier;

import org.lwjgl.system.NativeResource;
import org.sheepy.lily.core.api.adapter.IAdapter;

public interface IBarrierAdapter<T extends NativeResource> extends IAdapter
{
	void update(int index);
	VkBarrier<T> getBackend();
}
