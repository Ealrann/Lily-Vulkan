package org.sheepy.lily.vulkan.extra.api.terrain;

import org.sheepy.lily.vulkan.api.nativehelper.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.api.resource.IIndexedBuffer;

public interface IMeshObject
{
	IIndexedBuffer getIIndexedBuffer();
	IVkDescriptorSet getDescriptorSet();
	int getInstanceCount();
}
