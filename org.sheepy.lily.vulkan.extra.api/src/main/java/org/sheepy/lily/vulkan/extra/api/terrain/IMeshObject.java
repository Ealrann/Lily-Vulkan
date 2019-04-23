package org.sheepy.lily.vulkan.extra.api.terrain;

import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.resource.indexed.IndexedBuffer;

public interface IMeshObject
{
	IndexedBuffer<?> getIIndexedBuffer();
	IVkDescriptorSet getDescriptorSet();

	boolean update(IMeshStagingBuffer stagingBuffer);

	void setInstanceCount(int size);
	int getInstanceCount();
}
