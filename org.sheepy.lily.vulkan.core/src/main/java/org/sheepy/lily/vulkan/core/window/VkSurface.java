package org.sheepy.lily.vulkan.core.window;

import org.lwjgl.vulkan.VkInstance;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.KHRSurface.vkDestroySurfaceKHR;

public class VkSurface
{
	public final long ptr;

	private final VkInstance vkInstance;
	private final List<ISurfaceListener> listeners = new ArrayList<>();

	private boolean destroyed = false;

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
	public interface ISurfaceListener extends Runnable
	{
		void onSurfaceDeprecation();

		@Override
		default void run()
		{
			onSurfaceDeprecation();
		}
	}
}
