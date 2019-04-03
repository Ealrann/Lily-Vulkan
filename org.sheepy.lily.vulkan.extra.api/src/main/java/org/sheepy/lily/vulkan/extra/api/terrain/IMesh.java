package org.sheepy.lily.vulkan.extra.api.terrain;

import org.sheepy.lily.vulkan.api.resource.IVkDescriptorSet;

public interface IMesh
{

	long getVertexBufferAddress();

	long getIndexBufferAddress();

	int getIndicesCount();

	int getVerticesCount();
	
	IVkDescriptorSet getDescriptorSet();
}
