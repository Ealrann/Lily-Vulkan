package org.sheepy.lily.vulkan.resource.memorychunk;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;

public interface IMemoryChunkPartAdapter extends IAdapter
{
	IVulkanResourcePointer allocateVulkanResource(IVulkanContext context);
}

