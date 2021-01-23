package org.sheepy.lily.vulkan.resource.memorychunk;

import org.logoce.extender.api.IAdapter;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;

import java.util.function.LongConsumer;

public interface IBufferAdapter extends IAdapter, INotifier<IBufferAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<LongConsumer, Features> Size = Feature.newFeature();
	}

	long getSize(final IBuffer part);
}
