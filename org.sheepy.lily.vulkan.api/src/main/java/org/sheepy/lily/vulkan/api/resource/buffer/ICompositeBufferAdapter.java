package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

public interface ICompositeBufferAdapter extends IBufferAdapter
{
	long getSize(int componentIndex);
	long getOffset(int componentIndex);

	public static ICompositeBufferAdapter adapt(CompositeBuffer buffer)
	{
		return IAdapterFactoryService.INSTANCE.adapt(buffer, ICompositeBufferAdapter.class);
	}
}
