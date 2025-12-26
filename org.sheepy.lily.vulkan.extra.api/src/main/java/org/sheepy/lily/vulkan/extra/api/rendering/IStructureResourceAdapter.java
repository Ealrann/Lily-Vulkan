package org.sheepy.lily.vulkan.extra.api.rendering;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;

import java.util.List;

public interface IStructureResourceAdapter extends IAdapter
{
	List<? extends IVulkanResource> createMemoryChunk();
	List<? extends IVulkanImage> getImages();
}
