package org.sheepy.lily.vulkan.extra.api.rendering;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

public interface IDescriptorProviderAdapter extends IAdapter
{
	ResourceDescriptor buildForPipeline(ResourceDescriptorProvider provider,
										Structure structure);
	ResourceDescriptor buildForPart(ResourceDescriptorProvider provider,
									CompositeBuffer compositeBuffer);

	final class ResourceDescriptor
	{
		public final List<IResource> resources;
		public final List<IDescriptor> descriptors;

		public ResourceDescriptor(List<IResource> resources, List<IDescriptor> descriptors)
		{
			this.resources = List.copyOf(resources);
			this.descriptors = List.copyOf(descriptors);
		}
	}
}
