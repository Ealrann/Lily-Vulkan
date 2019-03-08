package org.sheepy.lily.vulkan.api.nativehelper.surface;

import static org.lwjgl.vulkan.KHRSurface.vkDestroySurfaceKHR;

import org.lwjgl.vulkan.VkInstance;

public class VkSurface
{
	public long ptr;

	private final VkInstance vkInstance;

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
			ptr = -1;
		}
	}

	public boolean isDeprecated()
	{
		return destroyed;
	}
}
