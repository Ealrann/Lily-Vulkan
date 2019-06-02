package org.sheepy.lily.vulkan.api.resource;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.Buffer;

public interface IBufferAdapter extends IDescriptedResourceAdapter, IResourceAdapter
{
	long getPtr();
	long getMemoryPtr();
	void pushData(ByteBuffer copyBuffer);

	public static IBufferAdapter adapt(Buffer buffer)
	{
		return IAdapterFactoryService.INSTANCE.adapt(buffer, IBufferAdapter.class);
	}
}
