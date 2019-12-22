package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImageView;

public abstract class AbstractImageAdapter implements IImageAdapter
{
	private final Image image;

	private VkImage imageBackend;
	private VkImageView imageView;
	private IImageLoader loader = null;
	private IExecutionContext executionContext;

	public AbstractImageAdapter(Image image)
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

		imageBackend = getBuilder(image).build();
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

	protected abstract VkImage.Builder getBuilder(Image image);

	public static interface IImageLoader
	{
		void load(IExecutionContext executionManager, VkImage backendBuffer);
	}
}
