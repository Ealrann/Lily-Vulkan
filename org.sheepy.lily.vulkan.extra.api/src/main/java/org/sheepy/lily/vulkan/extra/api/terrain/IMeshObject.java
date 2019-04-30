package org.sheepy.lily.vulkan.extra.api.terrain;

import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.resource.buffer.IStagingBuffer;

public interface IMeshObject
{
	IVkDescriptorSet getDescriptorSet();

	long getIndexBufferAddress();
	long getIndexBufferOffset();
	int getIndicesCount();

	long getVertexBufferAddress();
	long getVertexBufferOffset();

	void update(IStagingBuffer stagingBuffer);
	boolean hasChanged();

	void setInstanceCount(int size);
	int getInstanceCount();
}
