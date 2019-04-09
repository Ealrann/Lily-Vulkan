package org.sheepy.lily.vulkan.extra.api.terrain;

import org.sheepy.lily.vulkan.api.resource.IIndexedBuffer;
import org.sheepy.lily.vulkan.api.resource.IVkDescriptorSet;

public interface IMeshObject
{
	IIndexedBuffer getIIndexedBuffer();
	IVkDescriptorSet getDescriptorSet();
	int getInstanceCount();
}
