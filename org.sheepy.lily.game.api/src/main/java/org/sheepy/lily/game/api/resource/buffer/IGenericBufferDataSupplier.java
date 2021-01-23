package org.sheepy.lily.game.api.resource.buffer;

import org.logoce.extender.api.IAdapter;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.LongConsumer;

public interface IGenericBufferDataSupplier<T extends IGenericBufferDataSupplier.Features<T>> extends IAdapter,
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
