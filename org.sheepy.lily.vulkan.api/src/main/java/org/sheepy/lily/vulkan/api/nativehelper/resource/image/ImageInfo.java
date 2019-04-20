package org.sheepy.lily.vulkan.api.nativehelper.resource.image;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.enumeration.EImageUsage;
import org.sheepy.lily.vulkan.model.resource.Image;

public class ImageInfo
{
	public final int width;
	public final int height;
	public final int format;
	public final int usage;
	public final int properties;
	public final int tiling;
	public final int mipLevels;

	public ImageInfo(Image image)
	{
		this(image.getWidth(), image.getHeight(), image.getFormat().getValue(),
				convertUsage(image.getUsages()), image.getProperties(), image.getTiling(),
				image.getMipLevels());
	}

	private static int convertUsage(EList<EImageUsage> usages)
	{
		int res = 0;
		for (EImageUsage usage : usages)
		{
			res |= usage.getValue();
		}
		return res;
	}

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
