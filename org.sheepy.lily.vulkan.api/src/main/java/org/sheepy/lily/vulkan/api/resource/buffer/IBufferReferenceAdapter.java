package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;

public interface IBufferReferenceAdapter<T extends IBufferReference> extends IVulkanAdapter
{
	long getBufferPtr(T ref);
	long getOffset(T ref);

	@SuppressWarnings("unchecked")
	public static <T extends IBufferReference> IBufferReferenceAdapter<T> adapt(T bufferRef)
	{
		return IAdapterFactoryService.INSTANCE.adapt(bufferRef, IBufferReferenceAdapter.class);
	}
}
