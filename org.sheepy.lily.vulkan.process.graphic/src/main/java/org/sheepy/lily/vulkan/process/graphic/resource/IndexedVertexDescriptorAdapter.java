package org.sheepy.lily.vulkan.process.graphic.resource;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.resource.IVertexDescriptorAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.resource.indexed.VkIndexedVertexDescriptor;
import org.sheepy.vulkan.resource.indexed.VkVertexDescriptor.VkAttributeDescription;

@Adapter(scope = IndexedVertexDescriptor.class)
public class IndexedVertexDescriptorAdapter implements IVertexDescriptorAdapter
{
	@Override
	public VkIndexedVertexDescriptor buildVertexDescriptor(VertexDescriptor descriptor)
	{
		final List<VkAttributeDescription> attributes = new ArrayList<>();
		final var indexedDescriptor = (IndexedVertexDescriptor) descriptor;
		final var strideLength = indexedDescriptor.getStrideLength();
		final var indexType = indexedDescriptor.getIndexType();
		final var indexSize = getIndexSize(indexType);

		for (final var attribute : indexedDescriptor.getAttributes())
		{
			final var format = attribute.getFormat().getValue();
			final var offset = attribute.getOffset();
			final var description = new VkAttributeDescription(format, offset);

			attributes.add(description);
		}

		return new VkIndexedVertexDescriptor(strideLength, indexSize, attributes);
	}

	private static int getIndexSize(EIndexType indexType)
	{
		int res = 0;
		switch (indexType)
		{
		case UINT16:
			res = 2;
			break;
		case UINT32:
			res = 4;
			break;
		}
		return res;
	}
}
