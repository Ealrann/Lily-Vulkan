package org.sheepy.lily.vulkan.extra.api.sprite;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.model.resource.FileImage;

import java.util.List;
import java.util.stream.Stream;

public interface ISpriteSupplier extends IExtender, INotifier<ISpriteSupplier.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<SpriteListener, Features> Sprites = Feature.newFeature();

		List<Feature<?, ? super Features>> values = List.of(Sprites);
	}

	Stream<FileImage> images();
	int imageCount();

	@FunctionalInterface
	interface SpriteListener
	{
		void onChange(List<FileImage> addedSprites, List<FileImage> removedSprites);
	}
}
