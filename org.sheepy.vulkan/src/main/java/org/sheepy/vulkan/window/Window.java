package org.sheepy.vulkan.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFWVulkan.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.surface.VkSurface;
import org.sheepy.vulkan.window.IWindowListener.ICloseListener;
import org.sheepy.vulkan.window.IWindowListener.IOpenListener;
import org.sheepy.vulkan.window.IWindowListener.ISizeListener;
import org.sheepy.vulkan.window.IWindowListener.ISurfaceDeprecatedListener;

public class Window
{
	private static final String FAILED_TO_CREATE_SURFACE = "Failed to create surface";

	private final List<ISizeListener> sizeListeners = new ArrayList<>();
	private final List<ICloseListener> closeListeners = new ArrayList<>();
	private final List<IOpenListener> openListeners = new ArrayList<>();
	private final List<ISurfaceDeprecatedListener> surfaceListeners = new ArrayList<>();
	private final Scene scene;
	private final INotificationListener fullscreenListener = this::requestFullscreen;
	private final INotificationListener sizeListener = this::resize;

	private long id;

	private final String title;
	private boolean opened = false;
	private boolean cursorHide = false;

	private final long[] aSurface = new long[1];

	private GLFWWindowSizeCallback callback;

	private GLFWVidMode mode;
	private Vector2ic windowSize = null;
	private VkInstance vkInstance;

	private boolean fullscreenChangeRequested = false;

	public Window(Scene scene, String title)
	{
		this.scene = scene;
		this.title = title;
		load();
	}

	private void load()
	{
		glfwInit();
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API);
		glfwWindowHint(GLFW_AUTO_ICONIFY, GLFW_FALSE);
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);

		if (scene.isResizeable()) glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
	}

	private boolean disableResizeListener = false;

	public void open(VkInstance vkInstance)
	{
		final long glfwGetPrimaryMonitor = glfwGetPrimaryMonitor();
		long monitor = 0;

		this.vkInstance = vkInstance;
		fullscreenChangeRequested = false;
		mode = glfwGetVideoMode(glfwGetPrimaryMonitor);
		if (scene.isFullscreen())
		{
			monitor = glfwGetPrimaryMonitor;
			windowSize = scene.getSize();
			scene.setSize(new Vector2i(mode.width(), mode.height()));
		}

		final var size = scene.getSize();
		id = glfwCreateWindow(size.x(), size.y(), title, monitor, 0);
		hideCursor(cursorHide);
		callback = new GLFWWindowSizeCallback()
		{
			@Override
			public void invoke(long window, int width, int height)
			{
				disableResizeListener = true;
				scene.setSize(new Vector2i(width, height));
				fireResizeEvent();
				disableResizeListener = false;
			}
		};
		glfwSetWindowSizeCallback(id, callback);

		opened = true;

		scene.addListener(fullscreenListener, ApplicationPackage.SCENE__FULLSCREEN);
		scene.addListener(sizeListener, ApplicationPackage.SCENE__SIZE);

		fireOpenWindow();
		fireResizeEvent();

		glfwShowWindow(id);
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
		scene.removeListener(fullscreenListener, ApplicationPackage.SCENE__FULLSCREEN);
		scene.removeListener(sizeListener, ApplicationPackage.SCENE__SIZE);
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

	private void requestFullscreen(Notification notification)
	{
		if (notification.getNewBooleanValue() != notification.getOldBooleanValue())
		{
			fullscreenChangeRequested = true;

			fireSurfaceDeprecation();
		}
	}

	private void resize(Notification notification)
	{
		if (disableResizeListener == false)
		{
			final var oldSize = (Vector2ic) notification.getOldValue();
			final var newSize = (Vector2ic) notification.getNewValue();
			if (newSize.x() != oldSize.x() || newSize.y() != oldSize.y())
			{
				glfwSetWindowSize(id, newSize.x(), newSize.y());
			}
		}
	}

	private void manageFullscreenChange()
	{
		if (fullscreenChangeRequested)
		{
			if (scene.isFullscreen() == false)
			{
				disableResizeListener = true;
				scene.setSize(windowSize);
				disableResizeListener = false;
			}
			close();
			open(vkInstance);
		}
	}

	public static PointerBuffer getRequiredInstanceExtensions()
	{
		return glfwGetRequiredInstanceExtensions();
	}

	public Vector2ic getFramebufferSize()
	{
		final int[] width = new int[1];
		final int[] height = new int[1];

		glfwGetFramebufferSize(id, width, height);
		return new Vector2i(width[0], height[0]);
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

	public Vector2ic getSize()
	{
		return scene.getSize();
	}

	public boolean isOpenned()
	{
		return opened;
	}

	public void addListener(IWindowListener l)
	{
		if (l instanceof ISizeListener) sizeListeners.add((ISizeListener) l);
		else if (l instanceof ICloseListener) closeListeners.add((ICloseListener) l);
		else if (l instanceof IOpenListener) openListeners.add((IOpenListener) l);
		else if (l instanceof ISurfaceDeprecatedListener)
			surfaceListeners.add((ISurfaceDeprecatedListener) l);
	}

	public void removeListener(IWindowListener l)
	{
		if (l instanceof ISizeListener) sizeListeners.remove(l);
		else if (l instanceof ICloseListener) closeListeners.remove(l);
		else if (l instanceof IOpenListener) openListeners.remove(l);
		else if (l instanceof ISurfaceDeprecatedListener) surfaceListeners.remove(l);
	}

	private void fireResizeEvent()
	{
		for (final var listener : sizeListeners)
		{
			listener.onResize(scene.getSize());
		}
	}

	private void fireCloseWindow()
	{
		for (final var listener : closeListeners)
		{
			listener.onClose(id);
		}
	}

	private void fireOpenWindow()
	{
		for (final var listener : openListeners)
		{
			listener.onOpen(id);
		}
	}

	private void fireSurfaceDeprecation()
	{
		for (final var listener : surfaceListeners)
		{
			listener.onSurfaceDeprecation();
		}
	}
}
