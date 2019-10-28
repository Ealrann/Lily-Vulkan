package org.sheepy.lily.vulkan.extra.api.rendering;

import java.util.List;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;

public interface IResourceProviderAdapter extends IVulkanAdapter
{
	List<DescriptedResource> getResources(ResourceProvider provider);
}
