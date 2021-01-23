package org.sheepy.lily.vulkan.extra.api.rendering;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;

import java.util.List;
import java.util.stream.Stream;

public interface IDescriptorProviderAdapter extends IAdapter
{
	ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider, Structure structure);
	ResourceDescriptor buildForPart(ResourceDescriptorProvider provider, Stream<BufferViewer> bufferViewers);

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
