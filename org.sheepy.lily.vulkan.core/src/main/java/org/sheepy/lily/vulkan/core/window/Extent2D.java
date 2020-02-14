package org.sheepy.lily.vulkan.core.window;

public final class Extent2D
{
	public final int width;
	public final int height;

	public Extent2D(int width, int height)
	{
		this.width = width;
		this.height = height;
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
