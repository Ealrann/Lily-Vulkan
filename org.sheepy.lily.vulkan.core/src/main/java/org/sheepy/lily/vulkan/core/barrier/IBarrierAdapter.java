package org.sheepy.lily.vulkan.core.barrier;

import org.lwjgl.system.NativeResource;
import org.sheepy.lily.core.api.extender.IExtender;

public interface IBarrierAdapter<T extends NativeResource> extends IExtender
{
	void update(int index);
	VkBarrier<T> getBackend();
}
