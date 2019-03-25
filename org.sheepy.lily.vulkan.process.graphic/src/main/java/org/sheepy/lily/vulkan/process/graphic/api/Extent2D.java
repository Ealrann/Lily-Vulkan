package org.sheepy.lily.vulkan.process.graphic.api;

import org.lwjgl.vulkan.VkExtent2D;

public class Extent2D
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
		final VkExtent2D vkExtent = VkExtent2D.malloc();
		vkExtent.set(width, height);
		return vkExtent;
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
