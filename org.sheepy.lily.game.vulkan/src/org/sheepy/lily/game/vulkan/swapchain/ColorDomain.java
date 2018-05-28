package org.sheepy.lily.game.vulkan.swapchain;

public class ColorDomain
{
	private int colorFormat;
	private int colorSpace;
	
	public ColorDomain(int colorFormat, int colorSpace)
	{
		this.colorFormat = colorFormat;
		this.colorSpace = colorSpace;
	}
	
	public int getColorFormat()
	{
		return colorFormat;
	}

	public int getColorSpace()
	{
		return colorSpace;
	}
	
}