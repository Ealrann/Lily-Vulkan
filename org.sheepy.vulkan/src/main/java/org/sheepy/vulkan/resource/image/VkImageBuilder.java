package org.sheepy.vulkan.resource.image;

import org.sheepy.vulkan.resource.image.VkImage.Builder;

public final class VkImageBuilder implements Builder
{
	private final int width;
	private final int height;
	private final int format;
	private int usage = 0;
	private int properties = 0;
	private int tiling = 0;
	private int mipLevels = 1;
	private boolean fillWithZero = false;

	public VkImageBuilder(int width, int height, int format)
	{
		this.width = width;
		this.height = height;
		this.format = format;
	}

	public VkImageBuilder(Builder builder)
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

	public VkImageBuilder addUsage(int usage)
	{
		this.usage |= usage;
		return this;
	}

	public VkImageBuilder usage(int usage)
	{
		this.usage = usage;
		return this;
	}

	@Override
	public int usage()
	{
		return usage;
	}

	public VkImageBuilder properties(int properties)
	{
		this.properties = properties;
		return this;
	}

	@Override
	public int properties()
	{
		return properties;
	}

	public VkImageBuilder tiling(int tiling)
	{
		this.tiling = tiling;
		return this;
	}

	@Override
	public int tiling()
	{
		return tiling;
	}

	public VkImageBuilder mipLevels(int mipLevels)
	{
		this.mipLevels = mipLevels;
		return this;
	}

	@Override
	public int mipLevels()
	{
		return mipLevels;
	}

	public VkImageBuilder fillWithZero(boolean fillWithZero)
	{
		this.fillWithZero = fillWithZero;
		return this;
	}

	@Override
	public boolean fillWithZero()
	{
		return fillWithZero;
	}

	@Override
	public Builder copyImmutable()
	{
		return new ImmutableBuilder(this);
	}

	@Override
	public VkImage build()
	{
		return new VkImage(width, height, format, usage, properties, tiling, mipLevels,
				fillWithZero);
	}
}