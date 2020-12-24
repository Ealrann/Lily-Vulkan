package org.sheepy.lily.game.api.resource.image;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.extender.IExtender;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public interface IImageDataProviderAdapter extends IExtender, INotifier<IImageDataProviderAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Runnable, Features> Data = Feature.newFeature();
		Feature<Consumer<Vector2ic>, Features> Size = Feature.newFeature();
	}

	void fill(ByteBuffer buffer);

	Vector2ic size();
}
