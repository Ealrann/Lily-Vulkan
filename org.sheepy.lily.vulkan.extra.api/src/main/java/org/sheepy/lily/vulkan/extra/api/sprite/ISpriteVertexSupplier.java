package org.sheepy.lily.vulkan.extra.api.sprite;

import org.logoce.lmf.core.api.notification.IFeature;
import org.sheepy.lily.game.api.resource.buffer.IGenericBufferDataSupplier;

import java.util.List;
import java.util.function.IntConsumer;

public interface ISpriteVertexSupplier extends IGenericBufferDataSupplier<ISpriteVertexSupplier.Features>
{
	interface Features extends IGenericBufferDataSupplier.Features<Features>
	{
		IFeature<IntConsumer, Features> EntityCount = IFeature.newFeature();

		List<IFeature<?, ? super Features>> values = List.of(Data, Size, EntityCount);
	}

	int entityCount();
}
