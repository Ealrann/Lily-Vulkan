package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;
import org.sheepy.lily.vulkan.model.resource.StaticImage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

@Statefull
@Adapter(scope = StaticImage.class)
public class StaticImageAdapter extends Notifier<IVkImageAdapter.Features> implements IVkImageAdapter,
																					  IAllocableAdapter<ExecutionContext>
{
	private final StaticImage image;

	private VkImage imageBackend;
	private VkImageView imageView;

	private IImageLoader loader = null;

	public StaticImageAdapter(StaticImage image)
	{
		super(List.of(Features.Image, Features.View));

		this.image = image;
	}

	public void setLoader(IImageLoader loader)
	{
		this.loader = loader;
	}

	@Override
	public void allocate(ExecutionContext context)
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
	public void free(ExecutionContext context)
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

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width, vkImage.height);
	}

	public interface IImageLoader
	{
		void load(ExecutionContext executionManager, VkImage backendBuffer);
	}
}
