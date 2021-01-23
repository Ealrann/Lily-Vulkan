package org.sheepy.lily.vulkan.resource.memorychunk;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;

public interface IMemoryChunkPartAdapter extends IAdapter
{
	IVulkanResourcePointer allocateVulkanResource(IVulkanContext context);
}
