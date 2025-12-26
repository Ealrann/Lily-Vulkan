package org.sheepy.lily.vulkan.resource.memorychunk;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;

import java.util.function.LongConsumer;

public interface IBufferAdapter extends IAdapter, INotifier<IBufferAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<LongConsumer, Features> Size = IFeature.newFeature();
	}

	long getSize(final IBuffer part);
}

