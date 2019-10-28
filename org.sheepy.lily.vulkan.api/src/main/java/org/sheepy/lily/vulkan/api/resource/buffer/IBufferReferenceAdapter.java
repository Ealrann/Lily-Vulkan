package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;

public interface IBufferReferenceAdapter<T extends IBufferReference> extends IVulkanAdapter
{
	long getBufferPtr(T ref);
	long getOffset(T ref);
}
