package org.sheepy.vulkan.resource.image;

public class ImageInfo
{
	public int width;
	public int height;
	public int format;
	public int mipLevels = 1;
	public int usage;
	public int tiling = 0;
	public int properties;

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getFormat()
	{
		return format;
	}

	public void setFormat(int format)
	{
		this.format = format;
	}

	public int getMipLevels()
	{
		return mipLevels;
	}

	public void setMipLevels(int mipLevels)
	{
		this.mipLevels = mipLevels;
	}

	public int getUsage()
	{
		return usage;
	}

	public void setUsage(int usage)
	{
		this.usage = usage;
	}

	public int getTiling()
	{
		return tiling;
	}

	public void setTiling(int tiling)
	{
		this.tiling = tiling;
	}

	public int getProperties()
	{
		return properties;
	}

	public void setProperties(int properties)
	{
		this.properties = properties;
	}

}
