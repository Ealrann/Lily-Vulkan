package org.sheepy.lily.vulkan.core.window;

import static org.lwjgl.vulkan.KHRSurface.vkDestroySurfaceKHR;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkInstance;

public class VkSurface
{
	private final VkInstance vkInstance;

	public long ptr;
	private boolean destroyed = false;

	private final List<ISurfaceListener> listeners = new ArrayList<>();

	public VkSurface(VkInstance vkInstance, long surfacePtr)
	{
		this.vkInstance = vkInstance;
		this.ptr = surfacePtr;
	}

	public void free()
	{
		if (destroyed == false)
		{
			vkDestroySurfaceKHR(vkInstance, ptr, null);
			destroyed = true;

			fireDeprecation();
		}
	}

	public boolean isDeprecated()
	{
		return destroyed;
	}

	private void fireDeprecation()
	{
		for (final var listener : listeners)
		{
			listener.onSurfaceDeprecation();
		}
	}

	public void addListener(ISurfaceListener listener)
	{
		listeners.add(listener);
	}

	public void removeListener(ISurfaceListener listener)
	{
		listeners.remove(listener);
	}

	@FunctionalInterface
	public static interface ISurfaceListener
	{
		void onSurfaceDeprecation();
	}
}
