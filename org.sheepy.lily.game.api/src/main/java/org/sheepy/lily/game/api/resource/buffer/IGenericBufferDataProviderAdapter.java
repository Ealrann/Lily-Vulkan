package org.sheepy.lily.game.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.LongConsumer;

public interface IGenericBufferDataProviderAdapter<T extends IGenericBufferDataProviderAdapter.Features<T>> extends
																											IExtender,
																											INotifier<T>
{
	interface Features<T extends Features<T>> extends IFeatures<T>
	{
		Feature<Runnable, Features<?>> Data = Feature.newFeature();
		Feature<LongConsumer, Features<?>> Size = Feature.newFeature();

		List<Feature<?, Features<?>>> values = List.of(Data, Size);
	}

	void fill(ByteBuffer buffer);

	long size();
}
