package org.sheepy.lily.vulkan.api.nativehelper.surface;

import static org.lwjgl.vulkan.KHRSurface.vkDestroySurfaceKHR;

import org.lwjgl.vulkan.VkInstance;

public class VkSurface
{
	public long ptr;
	public final int width;
	public final int height;

	public final int[] size;
	private final VkInstance vkInstance;

	private boolean locked = false;
	private boolean detroyRequired = false;

	public VkSurface(VkInstance vkInstance, long surfacePtr, int width, int height)
	{
		this.vkInstance = vkInstance;
		this.ptr = surfacePtr;
		this.width = width;
		this.height = height;

		size = new int[] {
				width, height
		};
	}

	public void destroy()
	{
		if (locked != true)
		{
			vkDestroySurfaceKHR(vkInstance, ptr, null);
			ptr = -1;
		}
		else
		{
			detroyRequired = true;
		}
	}

	public void lock()
	{
		locked = true;
	}

	public void release()
	{
		locked = false;
		if (detroyRequired == true)
		{
			destroy();
		}
	}

	public boolean isDeprecated()
	{
		return detroyRequired;
	}
}
