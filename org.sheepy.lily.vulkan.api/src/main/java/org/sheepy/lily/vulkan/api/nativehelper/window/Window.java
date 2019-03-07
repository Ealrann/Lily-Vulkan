package org.sheepy.lily.vulkan.api.nativehelper.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFWVulkan.*;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2i;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.util.Logger;

public class Window
{
	private final List<IWindowListener> listeners = new ArrayList<>();
	private final List<ISurfaceListener> surfaceListeners = new ArrayList<>();

	private long id;

	private final String title;
	private final boolean resizeable;
	private boolean fullscreen;
	private boolean opened = false;

	private final long[] aSurface = new long[1];

	private GLFWWindowSizeCallback callback;

	private GLFWVidMode mode;
	private VkSurface surface;
	private Vector2i size = null;
	private Vector2i windowSize = null;
	private VkInstance vkInstance;

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
		glfwWindowHint(GLFW_AUTO_ICONIFY, GLFW_FALSE);

		if (resizeable) glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
	}

	public void setFullscreen(boolean fullscreen)
	{
		if (this.fullscreen != fullscreen)
		{
			this.fullscreen = fullscreen;

			if (fullscreen == false)
			{
				size = windowSize;
			}

			close();
			open(vkInstance);
		}
	}

	public void open(VkInstance vkInstance)
	{
		this.vkInstance = vkInstance;

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

		callback = new GLFWWindowSizeCallback()
		{
			@Override
			public void invoke(long window, int width, int height)
			{
				size = new Vector2i(width, height);
				destroySurface();
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
		destroySurface();
		glfwSetWindowSizeCallback(id, callback);
		callback.free();
		glfwDestroyWindow(id);
	}

	public void destroy()
	{
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

	public VkSurface createSurface()
	{
		destroySurface();
		int err = glfwCreateWindowSurface(vkInstance, id, null, aSurface);
		Logger.check(err, "Failed to create surface");

		surface = new VkSurface(vkInstance, aSurface[0], size.x, size.y);
		fireNewSurfaceEvent();

		return surface;
	}

	private void destroySurface()
	{
		if (surface != null)
		{
			surface.destroy();
			surface = null;
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

	public Vector2i getSize()
	{
		return size;
	}

	public boolean isOpenned()
	{
		return opened;
	}

	public void addSurfaceListener(ISurfaceListener listener)
	{
		surfaceListeners.add(listener);
	}

	public void removeSurfaceListener(ISurfaceListener listener)
	{
		surfaceListeners.remove(listener);
	}

	private void fireNewSurfaceEvent()
	{
		for (final ISurfaceListener listener : surfaceListeners)
		{
			listener.onNewSurface(surface);
		}
	}
}
