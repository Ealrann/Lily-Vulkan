package org.sheepy.vulkan.window;

import java.util.EventListener;

public interface IWindowListener extends EventListener
{

	void onWindowResize(long surface, int width, int height);

}
