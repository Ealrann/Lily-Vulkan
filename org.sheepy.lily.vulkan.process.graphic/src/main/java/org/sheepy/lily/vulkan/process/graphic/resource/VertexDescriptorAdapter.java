package org.sheepy.lily.vulkan.process.graphic.resource;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.resource.IVertexDescriptorAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor;
import org.sheepy.vulkan.resource.indexed.VkVertexDescriptor;
import org.sheepy.vulkan.resource.indexed.VkVertexDescriptor.VkAttributeDescription;

@Adapter(scope = VertexDescriptor.class)
public class VertexDescriptorAdapter implements IVertexDescriptorAdapter
{
	@Override
	public VkVertexDescriptor buildVertexDescriptor(VertexDescriptor descriptor)
	{
		final List<VkAttributeDescription> attributes = new ArrayList<>();
		final var strideLength = descriptor.getStrideLength();

		for (final AttributeDescription attribute : descriptor.getAttributes())
		{
			final var format = attribute.getFormat().getValue();
			final var offset = attribute.getOffset();
			final VkAttributeDescription description = new VkAttributeDescription(format, offset);
			attributes.add(description);
		}

		return new VkVertexDescriptor(strideLength, attributes);
	}
}
