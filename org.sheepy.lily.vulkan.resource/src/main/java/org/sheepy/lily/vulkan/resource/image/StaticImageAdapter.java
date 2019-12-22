package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImageView;

@Statefull
@Adapter(scope = StaticImage.class)
public class StaticImageAdapter implements IImageAdapter
{
	private final StaticImage image;

	private VkImage imageBackend;
	private VkImageView imageView;

	private IImageLoader loader = null;
	private IExecutionContext executionContext;

	public StaticImageAdapter(StaticImage image)
	{
		this.image = image;
	}

	public void setLoader(IImageLoader loader)
	{
		this.loader = loader;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		this.executionContext = context;
		final var logicalDevice = executionContext.getLogicalDevice();
		final var size = image.getSize();
		final var builder = new VkImage.VkImageBuilder(image, size.x(), size.y());
		builder.fillWith(image.getFillWith());

		imageBackend = builder.build();
		imageBackend.allocate(context);

		imageView = new VkImageView(logicalDevice.getVkDevice());
		imageView.allocate(	imageBackend.getPtr(),
							1,
							imageBackend.format,
							VK_IMAGE_ASPECT_COLOR_BIT);

		load();
	}

	public void load()
	{
		if (loader != null)
		{
			loader.load(executionContext, imageBackend);
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		imageView.free();
		imageView = null;

		imageBackend.free(context);
		imageBackend = null;
	}

	@Override
	public long getImagePtr()
	{
		return imageBackend.getPtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return imageBackend.getMemoryPtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageView.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return imageBackend;
	}

	public static interface IImageLoader
	{
		void load(IExecutionContext executionManager, VkImage backendBuffer);
	}
}
