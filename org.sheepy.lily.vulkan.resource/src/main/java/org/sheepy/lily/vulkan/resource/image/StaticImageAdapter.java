package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImageView;

@Statefull
@Adapter(scope = StaticImage.class)
public class StaticImageAdapter extends Notifier implements IImageAdapter
{
	private final StaticImage image;

	private VkImage imageBackend;
	private VkImageView imageView;

	private IImageLoader loader = null;

	public StaticImageAdapter(StaticImage image)
	{
		super(Features.values().length);

		this.image = image;
	}

	public void setLoader(IImageLoader loader)
	{
		this.loader = loader;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		final var size = image.getSize();
		final var builder = new VkImage.VkImageBuilder(image, size.x(), size.y());
		builder.fillWith(image.getFillWith());

		imageBackend = builder.build();
		imageBackend.allocate(context);

		imageView = new VkImageView(VK_IMAGE_ASPECT_COLOR_BIT);
		imageView.allocate(vkDevice, imageBackend);

		if (loader != null)
		{
			loader.load(context, imageBackend);
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		imageView.free(vkDevice);
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
