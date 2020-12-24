package org.sheepy.lily.game.api.window;

import org.joml.Vector2ic;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;
import org.logoce.notification.api.INotifier;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

public interface IWindow extends INotifier<IWindow.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Consumer<Vector2ic>, Features> Size = Feature.newFeature();
		Feature<LongConsumer, Features> Open = Feature.newFeature();
		Feature<LongConsumer, Features> Close = Feature.newFeature();
		Feature<Runnable, Features> SurfaceDeprecated = Feature.newFeature();
	}

	boolean isOpenned();
	long getPtr();
	void showCursor(boolean show);
	int getRefreshRate();
	Vector2ic getSize();
}
