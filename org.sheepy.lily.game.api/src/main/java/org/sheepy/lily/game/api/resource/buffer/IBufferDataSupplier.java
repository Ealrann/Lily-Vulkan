package org.sheepy.lily.game.api.resource.buffer;

import org.logoce.notification.api.Feature;

import java.util.List;

public interface IBufferDataSupplier extends IGenericBufferDataSupplier<IBufferDataSupplier.Features>
{
	interface Features extends IGenericBufferDataSupplier.Features<Features>
	{
		List<Feature<?, ? super Features>> values = List.of(Data, Size);
	}
}
