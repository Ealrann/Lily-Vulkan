package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;

import java.util.List;

public interface IDescriptorProviderAdapter extends IExtender
{
	ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider, Structure structure);
	ResourceDescriptor buildForPart(ResourceDescriptorProvider provider, BufferMemory bufferMemory);

	final class ResourceDescriptor
	{
		public final List<IVulkanResource> resources;
		public final List<IDescriptor> descriptors;

		public ResourceDescriptor(List<IVulkanResource> resources, List<IDescriptor> descriptors)
		{
			this.resources = List.copyOf(resources);
			this.descriptors = List.copyOf(descriptors);
		}
	}
}
