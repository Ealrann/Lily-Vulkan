package org.sheepy.lily.game.api.resource.buffer;

import org.sheepy.lily.core.api.notification.Feature;

import java.util.List;

public interface IBufferDataProviderAdapter extends IGenericBufferDataProviderAdapter<IBufferDataProviderAdapter.Features>
{
	interface Features extends IGenericBufferDataProviderAdapter.Features<Features>
	{
		List<Feature<?, ? super Features>> values = List.of(Data, Size);
	}
}
