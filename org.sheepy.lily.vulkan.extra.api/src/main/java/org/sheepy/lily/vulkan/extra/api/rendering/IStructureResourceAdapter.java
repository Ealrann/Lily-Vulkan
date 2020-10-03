package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;

import java.util.List;

public interface IStructureResourceAdapter extends IExtender
{
	List<? extends IVulkanResource> createMemoryChunk();
	List<? extends IVulkanImage> getImages();
}
