package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

public interface ICompositeBufferAdapter<T> extends IBufferAdapter
{
	long getSize(int componentIndex);
	long getOffset(int componentIndex);

	@SuppressWarnings("unchecked")
	public static <T> ICompositeBufferAdapter<T> adapt(CompositeBuffer<T> buffer)
	{
		return IAdapterFactoryService.INSTANCE.adapt(buffer, ICompositeBufferAdapter.class);
	}
}
