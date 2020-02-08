package org.sheepy.lily.vulkan.core.window;

import org.lwjgl.vulkan.VkExtent2D;

public final class Extent2D
{
	public final int width;
	public final int height;

	public Extent2D(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	/**
	 *
	 * Alloc a new Extent. You will have to manage the free.
	 *
	 * @return
	 */
	public VkExtent2D allocVkExtent2D()
	{
		return VkExtent2D.malloc().set(width, height);
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
