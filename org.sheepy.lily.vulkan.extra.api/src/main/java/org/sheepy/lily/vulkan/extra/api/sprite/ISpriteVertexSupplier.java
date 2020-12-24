package org.sheepy.lily.vulkan.extra.api.sprite;

import org.logoce.notification.api.Feature;
import org.sheepy.lily.game.api.resource.buffer.IGenericBufferDataSupplier;

import java.util.List;
import java.util.function.IntConsumer;

public interface ISpriteVertexSupplier extends IGenericBufferDataSupplier<ISpriteVertexSupplier.Features>
{
	interface Features extends IGenericBufferDataSupplier.Features<Features>
	{
		Feature<IntConsumer, Features> EntityCount = Feature.newFeature();

		List<Feature<?, ? super Features>> values = List.of(Data, Size, EntityCount);
	}

	int entityCount();
}
