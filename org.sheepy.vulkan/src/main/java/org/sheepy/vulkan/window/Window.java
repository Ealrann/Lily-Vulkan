package org.sheepy.vulkan.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFWVulkan.*;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.surface.VkSurface;

public class Window
{
	private static final String FAILED_TO_CREATE_SURFACE = "Failed to create surface";

	private final List<IWindowListener> listeners = new ArrayList<>();

	private long id;

	private final String title;
	private final boolean resizeable;
	private boolean fullscreen;
	private boolean opened = false;
	private boolean cursorHide = false;

	private final long[] aSurface = new long[1];

	private GLFWWindowSizeCallback callback;

	private GLFWVidMode mode;
	private Vector2i size = null;
	private Vector2i windowSize = null;
	private VkInstance vkInstance;

	private boolean fullscreenChangeRequested = false;

	public Window(Vector2ic initialSize, String title, boolean resizeable, boolean fullscreen)
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
		glfwWindowHint(GLFW_AUTO_ICONIFY, GLFW_FALSE);

		if (resizeable) glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
	}

	public void requestFullscreen(boolean fullscreen)
	{
		if (this.fullscreen != fullscreen)
		{
			this.fullscreen = fullscreen;

			fullscreenChangeRequested = true;

			fireSurfaceDeprecation();
		}
	}

	public void open(VkInstance vkInstance)
	{
		this.vkInstance = vkInstance;
		fullscreenChangeRequested = false;
		long monitor = 0;
		if (fullscreen)
		{
			monitor = glfwGetPrimaryMonitor();
			windowSize = size;
			size = new Vector2i(mode.width(), mode.height());
		}

		mode = glfwGetVideoMode(glfwGetPrimaryMonitor());

		id = glfwCreateWindow(size.x, size.y, title, monitor, 0);
		createSurface();
		hideCursor(cursorHide);
		callback = new GLFWWindowSizeCallback()
		{
			@Override
			public void invoke(long window, int width, int height)
			{
				size = new Vector2i(width, height);
				fireResizeEvent();
			}
		};
		glfwSetWindowSizeCallback(id, callback);

		opened = true;

		fireOpenWindow();
		fireResizeEvent();
	}

	public int getRefreshRate()
	{
		return mode.refreshRate();
	}

	public long getId()
	{
		return id;
	}

	public void close()
	{
		opened = false;
		fireCloseWindow();
		glfwSetWindowSizeCallback(id, null);
		callback.free();
		glfwDestroyWindow(id);
	}

	public void destroy()
	{
		glfwTerminate();
	}

	public boolean shouldClose()
	{
		return glfwWindowShouldClose(id);
	}

	public VkSurface createSurface()
	{
		manageFullscreenChange();

		final int err = glfwCreateWindowSurface(vkInstance, id, null, aSurface);
		Logger.check(err, FAILED_TO_CREATE_SURFACE);

		return new VkSurface(vkInstance, aSurface[0]);
	}

	private void manageFullscreenChange()
	{
		if (fullscreenChangeRequested)
		{
			if (fullscreen == false)
			{
				size = windowSize;
			}
			close();
			open(vkInstance);
		}
	}

	public static PointerBuffer getRequiredInstanceExtensions()
	{
		return glfwGetRequiredInstanceExtensions();
	}

	public void setSize(int x, int y)
	{
		if (x != size.x || y != size.y)
		{
			glfwSetWindowSize(id, x, y);
		}
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
			listener.onResize(size);
		}
	}

	private void fireCloseWindow()
	{
		for (final IWindowListener listener : listeners)
		{
			listener.onClose(id);
		}
	}

	private void fireOpenWindow()
	{
		for (final IWindowListener listener : listeners)
		{
			listener.onOpen(id);
		}
	}

	private void fireSurfaceDeprecation()
	{
		for (final IWindowListener listener : listeners)
		{
			listener.onSurfaceDeprecation();
		}
	}

	public Vector2i getSize()
	{
		return size;
	}

	public boolean isOpenned()
	{
		return opened;
	}

	public void hideCursor(boolean hide)
	{
		if (hide)
		{
			cursorHide = true;
			glfwSetInputMode(id, GLFW_CURSOR, GLFW_CURSOR_HIDDEN);
		}
		else
		{
			cursorHide = false;
			glfwSetInputMode(id, GLFW_CURSOR, GLFW_CURSOR_NORMAL);
		}
	}
}
