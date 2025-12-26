package org.sheepy.lily.vulkan.extra.api.sprite;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;
import org.sheepy.lily.core.model.resource.FileImage;

import java.util.List;
import java.util.stream.Stream;

public interface ISpriteSupplier extends IAdapter, INotifier<ISpriteSupplier.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<SpriteListener, Features> Sprites = IFeature.newFeature();

		List<IFeature<?, ? super Features>> values = List.of(Sprites);
	}

	Stream<FileImage> images();
	int imageCount();

	@FunctionalInterface
	interface SpriteListener
	{
		void onChange(List<FileImage> addedSprites, List<FileImage> removedSprites);
	}
}
