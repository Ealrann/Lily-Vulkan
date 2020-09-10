package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.sheepy.lily.game.api.resource.buffer.IGenericBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider;

public interface IRenderDataProviderAdapter<T extends IGenericBufferDataProviderAdapter.Features<T>> extends
																									 IGenericBufferDataProviderAdapter<T>
{
	static IRenderDataProviderAdapter<?> adapt(BufferDataProvider dataProvider)
	{
		return dataProvider.adapt(IRenderDataProviderAdapter.class);
	}
}
