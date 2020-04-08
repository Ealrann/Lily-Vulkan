package org.sheepy.lily.game.api.window;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.INotifier;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

public interface IWindow extends INotifier<IWindow.Features<?>>
{
	interface Features<T> extends IFeature<T, Features<?>>
	{
		int COUNT = 4;

		Features<Consumer<Vector2ic>> Size = new VectorFeature(0);
		Features<LongConsumer> Open = new LongFeature(1);
		Features<LongConsumer> Close = new LongFeature(2);
		Features<Runnable> SurfaceDeprecated = new RunnableFeature(3);

		final class VectorFeature extends Feature<Consumer<Vector2ic>, Features<?>> implements Features<Consumer<Vector2ic>>
		{
			public VectorFeature(final int ordinal)
			{
				super(ordinal);
			}
		}

		final class LongFeature extends Feature<LongConsumer, Features<?>> implements Features<LongConsumer>
		{
			public LongFeature(final int ordinal)
			{
				super(ordinal);
			}
		}

		final class RunnableFeature extends Feature<Runnable, Features<?>> implements Features<Runnable>
		{
			public RunnableFeature(final int ordinal)
			{
				super(ordinal);
			}
		}
	}

	boolean isOpenned();
	long getPtr();
	void hideCursor(boolean hide);
	int getRefreshRate();
	Vector2ic getSize();
}
