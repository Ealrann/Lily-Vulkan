package org.sheepy.lily.vulkan.api.nativehelper.window;

import java.util.EventListener;

import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;

public interface IWindowListener extends EventListener
{
	void onWindowResize(VkSurface surface);
}
