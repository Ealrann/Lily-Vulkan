package org.sheepy.vulkan.resource.indexed;

import java.util.List;

public class VkIndexedVertexDescriptor extends VkVertexDescriptor
{
	public final int indexSizeBytes;

	public VkIndexedVertexDescriptor(	int strideLength,
										int indexSizeBytes,
										List<VkAttributeDescription> attributes)
	{
		super(strideLength, attributes);
		this.indexSizeBytes = indexSizeBytes;
	}
}
