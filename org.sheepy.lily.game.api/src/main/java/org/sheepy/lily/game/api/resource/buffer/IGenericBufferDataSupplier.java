package org.sheepy.lily.game.api.resource.buffer;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.LongConsumer;

public interface IGenericBufferDataSupplier<T extends IGenericBufferDataSupplier.Features<T>> extends IAdapter,
																									  INotifier<T>
{
	interface Features<T extends Features<T>> extends IFeatures<T>
	{
		IFeature<Runnable, Features<?>> Data = IFeature.newFeature();
		IFeature<LongConsumer, Features<?>> Size = IFeature.newFeature();

		List<IFeature<?, Features<?>>> values = List.of(Data, Size);
	}

	void fill(ByteBuffer buffer);

	long size();
}
