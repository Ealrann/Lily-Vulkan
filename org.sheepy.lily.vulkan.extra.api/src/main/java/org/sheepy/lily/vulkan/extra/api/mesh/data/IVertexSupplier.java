package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.logoce.lmf.core.api.notification.IFeature;
import org.sheepy.lily.game.api.resource.buffer.IGenericBufferDataSupplier;

import java.util.List;
import java.util.function.IntConsumer;

public interface IVertexSupplier extends IRenderDataSupplier<IVertexSupplier.Features>
{
	interface Features extends IGenericBufferDataSupplier.Features<Features>
	{
		IFeature<IntConsumer, Features> VertexCount = IFeature.newFeature();

		List<IFeature<?, ? super Features>> values = List.of(Data, Size, VertexCount);
	}

	int getVertexCount();
}
