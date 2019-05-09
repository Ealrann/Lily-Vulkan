package org.sheepy.vulkan.resource.image;

import org.sheepy.vulkan.resource.image.VkImage.Builder;

public final class ImmutableBuilder implements Builder
{
	private final int width;
	private final int height;
	private final int format;
	private int usage = 0;
	private int properties = 0;
	private int tiling = 0;
	private int mipLevels = 1;
	private boolean fillWithZero = false;

	public ImmutableBuilder(Builder builder)
	{
		this.width = builder.width();
		this.height = builder.height();
		this.format = builder.format();
		this.usage = builder.usage();
		this.properties = builder.properties();
		this.tiling = builder.tiling();
		this.mipLevels = builder.mipLevels();
		this.fillWithZero = builder.fillWithZero();
	}

	@Override
	public int width()
	{
		return width;
	}

	@Override
	public int height()
	{
		return height;
	}

	@Override
	public int format()
	{
		return format;
	}

	@Override
	public int usage()
	{
		return usage;
	}

	@Override
	public int properties()
	{
		return properties;
	}

	@Override
	public int tiling()
	{
		return tiling;
	}

	@Override
	public int mipLevels()
	{
		return mipLevels;
	}

	@Override
	public boolean fillWithZero()
	{
		return fillWithZero;
	}

	@Override
	public Builder copyImmutable()
	{
		return this;
	}

	@Override
	public VkImage build()
	{
		return new VkImage(width, height, format, usage, properties, tiling, mipLevels,
				fillWithZero);
	}
}