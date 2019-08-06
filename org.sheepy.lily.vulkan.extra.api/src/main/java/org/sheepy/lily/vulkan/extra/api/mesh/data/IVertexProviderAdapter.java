package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;

public interface IVertexProviderAdapter extends IBufferDataProviderAdapter
{
	int getVertexCount();

	public static IVertexProviderAdapter adapt(VertexProvider<?> dataProvider)
	{
		return IAdapterFactoryService.INSTANCE.adapt(dataProvider, IVertexProviderAdapter.class);
	}
}
