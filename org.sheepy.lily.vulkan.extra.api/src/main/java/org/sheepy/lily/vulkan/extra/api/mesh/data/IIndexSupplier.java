package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.logoce.notification.api.Feature;
import org.sheepy.lily.game.api.resource.buffer.IGenericBufferDataSupplier;

import java.util.List;
import java.util.function.IntConsumer;

public interface IIndexSupplier extends IRenderDataSupplier<IIndexSupplier.Features>
{
	interface Features extends IGenericBufferDataSupplier.Features<Features>
	{
		Feature<IntConsumer, Features> IndexCount = Feature.newFeature();

		List<Feature<?, ? super Features>> values = List.of(Data, Size, IndexCount);
	}

	int getIndexCount();
}
