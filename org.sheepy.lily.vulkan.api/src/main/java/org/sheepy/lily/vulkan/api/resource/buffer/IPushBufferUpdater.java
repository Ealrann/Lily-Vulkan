package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

public interface IPushBufferUpdater extends IVulkanAdapter
{
	void beforePush(PushBuffer buffer);
}
