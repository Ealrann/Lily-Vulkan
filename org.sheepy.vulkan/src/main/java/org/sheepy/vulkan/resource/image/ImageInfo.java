package org.sheepy.vulkan.resource.image;

public class ImageInfo
{
	public final int width;
	public final int height;
	public final int format;
	public final int usage;
	public final int properties;
	public final int tiling;
	public final int mipLevels;

	public ImageInfo(int width, int height, int format, int usage, int properties)
	{
		this(width, height, format, usage, properties, 0, 1);
	}

	public ImageInfo(	int width,
						int height,
						int format,
						int usage,
						int properties,
						int tiling,
						int mipLevels)
	{
		this.width = width;
		this.height = height;
		this.format = format;
		this.usage = usage;
		this.properties = properties;
		this.tiling = tiling;
		this.mipLevels = mipLevels;
	}
}
