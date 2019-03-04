package org.sheepy.lily.vulkan.api.nativehelper.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFWVulkan.*;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.util.Logger;

public class Window
{
	private final List<IWindowListener> listeners = new ArrayList<>();

	private long id;

	private final String title;
	private final boolean resizeable;
	private final boolean fullscreen;
	private boolean opened = false;

	private VkSurface surface;

	private Vector2i size = null;

	public Window(Vector2i initialSize, String title, boolean resizeable, boolean fullscreen)
	{
		this.size = new Vector2i(initialSize);
		this.title = title;
		this.resizeable = resizeable;
		this.fullscreen = fullscreen;
		load();
	}

	private void load()
	{
		glfwInit();
		glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API);

		if (resizeable) glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
	}

	public void open(VkInstance vkInstance)
	{
		long monitor = 0;
		if (fullscreen)
		{
			monitor = glfwGetPrimaryMonitor();
		}

		id = glfwCreateWindow(size.x, size.y, title, monitor, 0);
		createSurface(vkInstance);

		final GLFWWindowSizeCallback callback = new GLFWWindowSizeCallback()
		{
			@Override
			public void invoke(long window, int width, int height)
			{
				size = new Vector2i(width, height);
				createSurface(vkInstance);
				fireResizeEvent();
			}
		};
		glfwSetWindowSizeCallback(id, callback);

		opened = true;
		fireResizeEvent();
	}

	public long getId()
	{
		return id;
	}

	public void close()
	{
		opened = false;
		destroySurface();
		glfwDestroyWindow(id);
		glfwTerminate();
	}

	public VkSurface getSurface()
	{
		return surface;
	}

	public boolean shouldClose()
	{
		return glfwWindowShouldClose(id);
	}

	private final long[] aSurface = new long[1];

	private void createSurface(VkInstance vkInstance)
	{
		destroySurface();
		int err = glfwCreateWindowSurface(vkInstance, id, null, aSurface);
		Logger.check(err, "Failed to create surface");

		surface = new VkSurface(vkInstance, aSurface[0], size.x, size.y);
	}

	private void destroySurface()
	{
		if (surface != null)
		{
			surface.destroy();
		}
	}

	public static PointerBuffer getRequiredInstanceExtensions()
	{
		return glfwGetRequiredInstanceExtensions();
	}

	public void setSize(int x, int y)
	{
		glfwSetWindowSize(id, x, y);
	}

	public void addListener(IWindowListener listener)
	{
		listeners.add(listener);
	}

	public void removeListener(IWindowListener listener)
	{
		listeners.remove(listener);
	}

	private void fireResizeEvent()
	{
		for (final IWindowListener listener : listeners)
		{
			listener.onWindowResize(surface);
		}
	}

	public boolean isOpenned()
	{
		return opened;
	}
}
