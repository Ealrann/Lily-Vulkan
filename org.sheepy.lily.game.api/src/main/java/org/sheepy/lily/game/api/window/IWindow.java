package org.sheepy.lily.game.api.window;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;
import org.logoce.lmf.core.api.notification.INotifier;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

public interface IWindow extends INotifier<IWindow.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<Consumer<Vector2ic>, Features> Size = IFeature.newFeature();
		IFeature<LongConsumer, Features> Open = IFeature.newFeature();
		IFeature<LongConsumer, Features> Close = IFeature.newFeature();
		IFeature<Runnable, Features> SurfaceDeprecated = IFeature.newFeature();
	}

	boolean isOpenned();
	long getPtr();
	void showCursor(boolean show);
	int getRefreshRate();
	Vector2ic getSize();
}
