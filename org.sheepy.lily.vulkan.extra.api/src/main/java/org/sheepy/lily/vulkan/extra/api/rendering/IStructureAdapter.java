package org.sheepy.lily.vulkan.extra.api.rendering;

import org.logoce.extender.api.IAdapter;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import java.util.function.IntConsumer;

public interface IStructureAdapter extends IAdapter, INotifier<IStructureAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<IntConsumer, Features> InstanceCount = Feature.newFeature();
	}

	int getPartCount(Structure structure);
	int getInstanceCount(Structure structure);
}
