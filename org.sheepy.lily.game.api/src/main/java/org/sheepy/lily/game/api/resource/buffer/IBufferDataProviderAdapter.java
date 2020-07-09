package org.sheepy.lily.game.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

import java.nio.ByteBuffer;
import java.util.function.LongConsumer;

public interface IBufferDataProviderAdapter extends IExtender, INotifier<IBufferDataProviderAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Runnable, Features> Data = Feature.newFeature();
		Feature<LongConsumer, Features> Size = Feature.newFeature();
	}

	void fill(ByteBuffer buffer);
	void fetch(ByteBuffer buffer);

	long size();

	default int minAlignment()
	{
		return 1;
	}
}
