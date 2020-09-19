package org.sheepy.lily.game.api.resource.buffer;

import org.sheepy.lily.core.api.notification.Feature;

import java.util.List;

public interface IBufferDataSupplier extends IGenericBufferDataSupplier<IBufferDataSupplier.Features>
{
	interface Features extends IGenericBufferDataSupplier.Features<Features>
	{
		List<Feature<?, ? super Features>> values = List.of(Data, Size);
	}
}
