package org.sheepy.lily.vulkan.api.nativehelper.window;

import java.util.EventListener;

import org.joml.Vector2i;

public interface IWindowListener extends EventListener
{
	default void onResize(Vector2i size) {};
	
	default void onClose(long oldId) {};
	
	default void onOpen(long id) {};
}
