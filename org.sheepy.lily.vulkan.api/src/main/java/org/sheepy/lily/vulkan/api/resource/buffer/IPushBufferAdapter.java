package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.vulkan.resource.staging.IStagingBuffer;

public interface IPushBufferAdapter extends IVulkanAdapter
{
	IStagingBuffer getStagingBuffer();

	public static IPushBufferAdapter adapt(PushBuffer buffer)
	{
		return IAdapterFactoryService.INSTANCE.adapt(buffer, IPushBufferAdapter.class);
	}
}
