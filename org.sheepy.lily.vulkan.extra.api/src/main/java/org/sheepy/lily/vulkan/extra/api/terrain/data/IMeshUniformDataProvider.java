package org.sheepy.lily.vulkan.extra.api.terrain.data;

import org.sheepy.lily.vulkan.api.nativehelper.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.api.nativehelper.resource.buffer.IBufferBackend;

public interface IMeshUniformDataProvider extends IMeshDataProvider
{
	IVkDescriptor createDescriptor(IBufferBackend buffer, int offset);
}
