package org.sheepy.vulkan.api.window;

import org.sheepy.common.api.types.SVector2f;

public interface IWindow
{
	boolean shouldClose();

	SVector2f getCursorPosition();

	void addListener(IWindowListener listener);

	void removeListener(IWindowListener listener);

	Surface getSurface();

	long getId();
}
