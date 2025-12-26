package org.sheepy.lily.game.api.resource.image;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public interface IImageDataProviderAdapter extends IAdapter, INotifier<IImageDataProviderAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<Runnable, Features> Data = IFeature.newFeature();
		IFeature<Consumer<Vector2ic>, Features> Size = IFeature.newFeature();
	}

	void fill(ByteBuffer buffer);

	Vector2ic size();
}
