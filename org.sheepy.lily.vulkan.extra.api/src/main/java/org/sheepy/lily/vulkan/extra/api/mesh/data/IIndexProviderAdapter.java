package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.game.api.resource.buffer.IGenericBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider;

import java.util.List;
import java.util.function.IntConsumer;

public interface IIndexProviderAdapter extends IRenderDataProviderAdapter<IIndexProviderAdapter.Features>
{
	interface Features extends IGenericBufferDataProviderAdapter.Features<Features>
	{
		Feature<IntConsumer, Features> IndexCount = Feature.newFeature();

		List<Feature<?, ? super Features>> values = List.of(Data, Size, IndexCount);
	}

	int getIndexCount();

	static IIndexProviderAdapter adapt(BufferDataProvider dataProvider)
	{
		return dataProvider.adapt(IIndexProviderAdapter.class);
	}
}
