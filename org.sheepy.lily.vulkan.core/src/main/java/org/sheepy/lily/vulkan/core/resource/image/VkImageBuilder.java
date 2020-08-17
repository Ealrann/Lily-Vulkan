package org.sheepy.lily.vulkan.core.resource.image;

import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.image.ImageInfo;

import java.nio.ByteBuffer;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

public final class VkImageBuilder extends IVkImageBuilder.AbstractVkImageBuilder implements IVkImageBuilder
{
	private final int width;
	private final int height;
	private final int format;
	private int usage = 0;
	private int tiling = 0;
	private int mipLevels = 1;
	private boolean fillWithZero = false;
	private ByteBuffer fillWith = null;
	private EImageLayout initialLayout = null;
	private int aspect = VK_IMAGE_ASPECT_COLOR_BIT;
	private String name;

	public VkImageBuilder(String name, int width, int height, int format)
	{
		this.name = name;
		this.width = width;
		this.height = height;
		this.format = format;
	}

	public VkImageBuilder(String name, ImageInfo info, int width, int height)
	{
		this.name = name;
		this.width = width;
		this.height = height;
		this.format = info.getFormat().getValue();
		this.usage = VulkanModelUtil.getEnumeratedFlag(info.getUsages());
		this.tiling = info.getTiling();
		this.mipLevels = info.getMipLevels();
		this.initialLayout = info.getInitialLayout();
	}

	public VkImageBuilder(IVkImageBuilder builder)
	{
		this.name = builder.name();
		this.width = builder.width();
		this.height = builder.height();
		this.format = builder.format();
		this.usage = builder.usage();
		this.tiling = builder.tiling();
		this.mipLevels = builder.mipLevels();
		this.fillWithZero = builder.fillWithZero();
		this.initialLayout = builder.initialLayout();
		this.aspect = builder.aspect();
	}

	@Override
	public int aspect()
	{
		return aspect;
	}

	public VkImageBuilder aspect(int aspect)
	{
		this.aspect = aspect;
		return this;
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

	public VkImageBuilder computeMipLevels()
	{
		mipLevels = (int) Math.floor(log2nlz(Math.max(width, height))) + 1;
		return this;
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

	public VkImageBuilder fillWith(ByteBuffer fillWith)
	{
		this.fillWith = fillWith;
		return this;
	}

	@Override
	public ByteBuffer fillWith()
	{
		return fillWith;
	}

	public AbstractVkImageBuilder initialLayout(EImageLayout initialLayout)
	{
		this.initialLayout = initialLayout;
		return this;
	}

	@Override
	public EImageLayout initialLayout()
	{
		return initialLayout;
	}

	@Override
	public String name()
	{
		return name;
	}

	public AbstractVkImageBuilder name(String name)
	{
		this.name = name;
		return this;
	}

	private static int log2nlz(int bits)
	{
		if (bits == 0) return 0;
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	static final class ImmutableBuilder extends IVkImageBuilder.AbstractVkImageBuilder
	{
		private final String name;
		private final int width;
		private final int height;
		private final int format;
		private final int usage;
		private final int tiling;
		private final int mipLevels;
		private final boolean fillWithZero;
		private final ByteBuffer fillWith;
		private final EImageLayout initialLayout;
		private final int aspect;

		public ImmutableBuilder(IVkImageBuilder builder)
		{
			this.name = builder.name();
			this.width = builder.width();
			this.height = builder.height();
			this.format = builder.format();
			this.usage = builder.usage();
			this.tiling = builder.tiling();
			this.mipLevels = builder.mipLevels();
			this.fillWithZero = builder.fillWithZero();
			this.fillWith = builder.fillWith();
			this.initialLayout = builder.initialLayout();
			this.aspect = builder.aspect();
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
		public int aspect()
		{
			return aspect;
		}

		@Override
		public boolean fillWithZero()
		{
			return fillWithZero;
		}

		@Override
		public ByteBuffer fillWith()
		{
			return fillWith;
		}

		@Override
		public EImageLayout initialLayout()
		{
			return initialLayout;
		}

		@Override
		public IVkImageBuilder copyImmutable()
		{
			return new ImmutableBuilder(this);
		}

		@Override
		public String name()
		{
			return name;
		}
	}
}
