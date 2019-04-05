package org.sheepy.lily.vulkan.extra.api.terrain;

import java.util.List;

import org.sheepy.lily.vulkan.api.resource.IVkDescriptor;

public interface IMesh
{
	long getVertexBufferAddress();

	long getIndexBufferAddress();

	int getIndicesCount();

	int getVerticesCount();

	List<IVkDescriptor> getDescriptors();
}
