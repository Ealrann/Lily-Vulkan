package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.extender.IExtender;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;

import java.util.function.LongConsumer;

public interface IBufferAdapter extends IExtender, INotifier<IBufferAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<LongConsumer, Features> Size = Feature.newFeature();
	}

	long getSize(final IBuffer part);
}
