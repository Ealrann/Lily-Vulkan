package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.resource.staging.IStagingBuffer;

public interface IPushBufferAdapter extends IVulkanAdapter
{
	IStagingBuffer getStagingBuffer();
}
