package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;

public interface IMemoryChunkPartAdapter extends IExtender
{
	IVulkanResourcePointer allocateVulkanResource(IVulkanContext context);
}
