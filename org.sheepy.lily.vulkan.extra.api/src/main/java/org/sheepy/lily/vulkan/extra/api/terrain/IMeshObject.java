package org.sheepy.lily.vulkan.extra.api.terrain;

import org.sheepy.lily.vulkan.api.nativehelper.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.api.nativehelper.resource.indexed.IndexedBuffer;

public interface IMeshObject
{
	IndexedBuffer<?> getIIndexedBuffer();
	IVkDescriptorSet getDescriptorSet();

	boolean update(IMeshStagingBuffer stagingBuffer);

	void setInstanceCount(int size);
	int getInstanceCount();
}
