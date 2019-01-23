package org.sheepy.lily.vulkan.api.window;

import java.util.EventListener;

public interface IWindowListener extends EventListener
{
	void onWindowResize(Surface surface);
}
