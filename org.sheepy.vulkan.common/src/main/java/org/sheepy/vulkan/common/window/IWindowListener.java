package org.sheepy.vulkan.common.window;

import java.util.EventListener;

public interface IWindowListener extends EventListener
{

	void onWindowResize(Surface surface);

}
