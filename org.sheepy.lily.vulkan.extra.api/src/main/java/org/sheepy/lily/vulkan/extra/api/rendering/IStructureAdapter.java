package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import java.util.function.IntConsumer;

public interface IStructureAdapter extends IExtender, INotifier<IStructureAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<IntConsumer, Features> InstanceCount = Feature.newFeature();
	}

	int getPartCount(Structure structure);
	int getInstanceCount(Structure structure);
}
