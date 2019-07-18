package org.sheepy.lily.vulkan.api.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.resource.IDescriptedResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.IBuffer;

public interface IBufferAdapter extends IDescriptedResourceAdapter, IResourceAdapter
{
	long getPtr();
	long getMemoryPtr();
	
	@Deprecated
	void pushData(ByteBuffer data);

	public static IBufferAdapter adapt(IBuffer buffer)
	{
		return IAdapterFactoryService.INSTANCE.adapt(buffer, IBufferAdapter.class);
	}
}
