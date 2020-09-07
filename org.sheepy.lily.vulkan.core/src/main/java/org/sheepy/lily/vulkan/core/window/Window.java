package org.sheepy.lily.vulkan.core.window;

import org.eclipse.emf.common.notify.Notification;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.List;
import java.util.function.Consumer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFWVulkan.glfwCreateWindowSurface;
import static org.lwjgl.glfw.GLFWVulkan.glfwGetRequiredInstanceExtensions;

public final class Window extends Notifier<IWindow.Features> implements IWindow
{
	private static final String FAILED_TO_CREATE_SURFACE = "Failed to create surface";

	private final Scene scene;
	private final Consumer<Notification> fullscreenListener = this::requestFullscreen;
	private final Consumer<Notification> sizeListener = this::resize;

	private long ptr;
	private final String title;
	private boolean opened = false;
	private boolean cursorVisible = true;

	private GLFWWindowSizeCallback callback;
	private GLFWVidMode mode;
	private Vector2ic windowSize = null;

	private boolean fullscreenChangeRequested = false;

	public Window(Scene scene, String title)
	{
		super(List.of(Features.Size, Features.Open, Features.Close, Features.SurfaceDeprecated));
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

	public void open()
	{
		final long glfwGetPrimaryMonitor = glfwGetPrimaryMonitor();
		long monitor = 0;

		fullscreenChangeRequested = false;
		mode = glfwGetVideoMode(glfwGetPrimaryMonitor);
		if (scene.isFullscreen())
		{
			monitor = glfwGetPrimaryMonitor;
			windowSize = scene.getSize();
			scene.setSize(new Vector2i(mode.width(), mode.height()));
		}

		final var size = scene.getSize();
		ptr = glfwCreateWindow(size.x(), size.y(), title, monitor, 0);
		setCursorVisible(cursorVisible);
		callback = new GLFWWindowSizeCallback()
		{
			@Override
			public void invoke(long window, int width, int height)
			{
				disableResizeListener = true;
				final Vector2i size = new Vector2i(width, height);
				scene.setSize(size);
				Window.this.notify(Features.Size, size);
				disableResizeListener = false;
			}
		};
		glfwSetWindowSizeCallback(ptr, callback);

		opened = true;

		scene.listen(fullscreenListener, ApplicationPackage.SCENE__FULLSCREEN);
		scene.listen(sizeListener, ApplicationPackage.SCENE__SIZE);

		Window.this.notify(Features.Open, ptr);
		Window.this.notify(Features.Size, scene.getSize());

		glfwShowWindow(ptr);
	}

	@Override
	public int getRefreshRate()
	{
		return mode.refreshRate();
	}

	@Override
	public long getPtr()
	{
		return ptr;
	}

	public void close()
	{
		opened = false;
		Window.this.notify(Features.Close, ptr);
		glfwSetWindowSizeCallback(ptr, null);
		callback.free();
		glfwDestroyWindow(ptr);
		scene.sulk(fullscreenListener, ApplicationPackage.SCENE__FULLSCREEN);
		scene.sulk(sizeListener, ApplicationPackage.SCENE__SIZE);
	}

	public void destroy()
	{
		glfwTerminate();
	}

	public boolean shouldClose()
	{
		return glfwWindowShouldClose(ptr);
	}

	public VkSurface createSurface(VkInstance vkInstance)
	{
		manageFullscreenChange();

		final long[] aSurface = new long[1];
		final int err = glfwCreateWindowSurface(vkInstance, ptr, null, aSurface);
		Logger.check(err, FAILED_TO_CREATE_SURFACE);

		return new VkSurface(vkInstance, aSurface[0]);
	}

	private void requestFullscreen(Notification notification)
	{
		if (notification.getNewBooleanValue() != notification.getOldBooleanValue())
		{
			fullscreenChangeRequested = true;
			Window.this.notify(Features.SurfaceDeprecated);
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
				glfwSetWindowSize(ptr, newSize.x(), newSize.y());
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
			open();
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

		glfwGetFramebufferSize(ptr, width, height);
		return new Vector2i(width[0], height[0]);
	}

	@Override
	public void showCursor(boolean show)
	{
		cursorVisible = show;
		if (isOpenned())
		{
			setCursorVisible(show);
		}
	}

	private void setCursorVisible(boolean visible)
	{
		if (visible)
		{
			glfwSetInputMode(ptr, GLFW_CURSOR, GLFW_CURSOR_NORMAL);
		}
		else
		{
			glfwSetInputMode(ptr, GLFW_CURSOR, GLFW_CURSOR_HIDDEN);
		}
	}

	@Override
	public Vector2ic getSize()
	{
		return scene.getSize();
	}

	@Override
	public boolean isOpenned()
	{
		return opened;
	}
}
