package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

public interface IPushBufferUpdater extends IVulkanAdapter
{
	void beforePush(PushBuffer buffer);

	public static IPushBufferUpdater adapt(PushBuffer buffer)
	{
		return IAdapterFactoryService.INSTANCE.adapt(buffer, IPushBufferUpdater.class);
	}
}
