package org.sheepy.vulkan.api.window;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public interface IWindow
{
	boolean shouldClose();
	
	void setMouseButtonCallback(GLFWMouseButtonCallback callback);

	void setKeyCallback(GLFWKeyCallback callback);

	double[] getCursorPosition();

	void addListener(IWindowListener listener);

	void removeListener(IWindowListener listener);

	Surface getSurface();
	
	long getId();
}
