package org.sheepy.vulkan.window;

import java.util.EventListener;

public interface IWindowListener extends EventListener
{

	void onWindowResize(Surface surface);

}
