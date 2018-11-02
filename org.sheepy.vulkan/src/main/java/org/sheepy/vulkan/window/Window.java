package org.sheepy.vulkan.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFWVulkan.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.common.api.types.SVector2i;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.util.VulkanUtils;
import org.sheepy.vulkan.util.Logger;

public class Window
{
	private final VulkanApplication application;

	private final List<IWindowListener> listeners = new ArrayList<>();

	private long id;
	private Surface surface;

	public Window(VulkanApplication application)
	{
		this.application = application;
		load();
	}

	private void load()
	{
		glfwInit();
		glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API);

		if (application.isResizeable()) glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
	}

	public void open(VkInstance vkInstance)
	{
		long monitor = 0;
		if (application.isFullscreen())
		{
			monitor = glfwGetPrimaryMonitor();
		}

		final SVector2i size = application.getSize();
		id = glfwCreateWindow(size.x, size.y, application.getTitle(), monitor, 0);
		createSurface(vkInstance, size.x, size.y);
		final GLFWWindowSizeCallback callback = new GLFWWindowSizeCallback()
		{
			@Override
			public void invoke(long window, int width, int height)
			{
				createSurface(vkInstance, width, height);
			}
		};
		glfwSetWindowSizeCallback(id, callback);
	}

	public void setMouseButtonCallback(GLFWMouseButtonCallback callback)
	{
		glfwSetMouseButtonCallback(id, callback);
	}

	public void setKeyCallback(GLFWKeyCallback callback)
	{
		glfwSetKeyCallback(id, callback);
	}

	private final double[] cursorPositionX = new double[1];
	private final double[] cursorPositionY = new double[1];
	private final double[] cursorPosition = new double[2];

	public double[] getCursorPosition()
	{
		// The elegance itself
		glfwGetCursorPos(id, cursorPositionX, cursorPositionY);
		cursorPosition[0] = cursorPositionX[0];
		cursorPosition[1] = cursorPositionY[0];
		return cursorPosition;
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

	public long getId()
	{
		return id;
	}

	public Surface getSurface()
	{
		return surface;
	}

	public void close()
	{
		glfwDestroyWindow(id);
		glfwTerminate();
	}

	public boolean shouldClose()
	{
		return glfwWindowShouldClose(id);
	}

	private final long[] aSurface = new long[1];

	private void createSurface(VkInstance vkInstance, int width, int height)
	{
		int err = glfwCreateWindowSurface(vkInstance, id, null, aSurface);
		Logger.check(err, "Failed to create surface");

		surface = new Surface(aSurface[0], width, height);

		fireResizeEvent();
	}

	public static PointerBuffer getRequiredInstanceExtensions()
	{
		return glfwGetRequiredInstanceExtensions();
	}

	public static void pollEvents()
	{
		glfwPollEvents();
	}

	public void setSize(int x, int y)
	{
		glfwSetWindowSize(id, x, y);
	}
}
