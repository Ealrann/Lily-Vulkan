package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.model.resource.IBufferObject;

import java.util.function.LongConsumer;

public interface IBufferObjectAdapter extends IExtender, INotifier<IBufferObjectAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<LongConsumer, Features> Size = Feature.newFeature();
	}

	long getSize(final IBufferObject part);
	int getUsage(final IBufferObject part);
}
