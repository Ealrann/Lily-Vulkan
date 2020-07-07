package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart;

import java.util.function.LongConsumer;

public interface IMemoryPartAdapter extends IExtender, INotifier<IMemoryPartAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<LongConsumer, Features> Size = Feature.newFeature();
	}

	long getSize(final IMemoryChunkPart part);
	int getUsage(IMemoryChunkPart part);
}
