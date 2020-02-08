package org.sheepy.lily.game.api.window;

import java.util.EventListener;

import org.joml.Vector2ic;

public interface IWindowListener extends EventListener
{
	@FunctionalInterface
	interface ISizeListener extends IWindowListener
	{
		void onResize(Vector2ic size);
	}

	@FunctionalInterface
	interface ICloseListener extends IWindowListener
	{
		void onClose(long oldId);
	}

	@FunctionalInterface
	interface IOpenListener extends IWindowListener
	{
		void onOpen(long id);
	}

	@FunctionalInterface
	interface ISurfaceDeprecatedListener extends IWindowListener
	{
		void onSurfaceDeprecation();
	}
}
