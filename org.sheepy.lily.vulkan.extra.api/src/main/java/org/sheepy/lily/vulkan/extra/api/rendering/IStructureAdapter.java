package org.sheepy.lily.vulkan.extra.api.rendering;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import java.util.function.IntConsumer;

public interface IStructureAdapter extends IAdapter, INotifier<IStructureAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<IntConsumer, Features> InstanceCount = IFeature.newFeature();
	}

	int getPartCount(Structure structure);
	int getInstanceCount(Structure structure);
}
