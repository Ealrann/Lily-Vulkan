package org.sheepy.lily.vulkan.extra.api.terrain.data;

import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.resource.buffer.IBufferBackend;

public interface IMeshUniformDataProvider extends IMeshDataProvider
{
	IVkDescriptor createDescriptor(IBufferBackend buffer, int offset);
}
