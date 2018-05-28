package org.sheepy.lily.game.vulkan.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFWVulkan.glfwCreateWindowSurface;
import static org.lwjgl.glfw.GLFWVulkan.glfwGetRequiredInstanceExtensions;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.lily.game.vulkan.util.VulkanUtils;

public class Window
{
	private int width;
	private int height;

	public List<IWindowListener> listeners = new ArrayList<>();
	
	private long id;
	private long surface;
	
	public Window(int initialWidth, int initialHeight)
	{
		this.width = initialWidth;
		this.height = initialHeight;
		
		load();
	}
	
	private void load()
	{
		glfwInit();
		glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
	}

	public void open(VkInstance vkInstance)
	{
		id = glfwCreateWindow(width, height, "Vulkan", 0, 0);
		createSurface(vkInstance);
		GLFWWindowSizeCallback callback = new GLFWWindowSizeCallback()
		{
			@Override
			public void invoke(long window, int width, int height)
			{
				createSurface(vkInstance);
				fireResizeEvent(width, height);
			}
		};
		glfwSetWindowSizeCallback(id, callback);
	}
	
	public void addListener(IWindowListener listener)
	{
		listeners.add(listener);
	}
	
	public void removeListener(IWindowListener listener)
	{
		listeners.remove(listener);
	}
	
	private void fireResizeEvent(int width, int height)
	{
		for (IWindowListener listener : listeners)
		{
			listener.onWindowResize(surface, width, height);
		}
	}
	
	public long getId()
	{
		return id;
	}
	
	public long getSurface()
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
	
	private long[] aSurface = new long[1];
	private void createSurface(VkInstance vkInstance)
	{
		int err = glfwCreateWindowSurface(vkInstance, id, null, aSurface);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError(
					"Failed to create surface: " + VulkanUtils.translateVulkanResult(err));
		}
		
		surface = aSurface[0];
	}

	public PointerBuffer getRequiredInstanceExtensions()
	{
		return  glfwGetRequiredInstanceExtensions();
	}

	public void pollEvents()
	{
		glfwPollEvents();		
	}
}
