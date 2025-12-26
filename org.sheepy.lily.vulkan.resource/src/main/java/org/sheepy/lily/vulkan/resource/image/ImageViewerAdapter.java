package org.sheepy.lily.vulkan.resource.image;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.image.IImageDataProviderAdapter;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAdapter;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

@ModelExtender(scope = ImageViewer.class)
@Adapter
public final class ImageViewerAdapter implements IMemoryChunkPartAdapter
{
	private final ImageViewer image;

	private VkImage imageBackend;

	public ImageViewerAdapter(final ImageViewer image)
	{
		this.image = image;
	}

	public VkImage getImageBackend()
	{
		return imageBackend;
	}

	@Override
	public IVulkanResourcePointer allocateVulkanResource(final IVulkanContext context)
	{
		final var dataProviderAdapter = image.dataProvider().adapt(IImageDataProviderAdapter.class);
		final var size = dataProviderAdapter.size();
		final var builder = new VkImageBuilder(image.name(), image, size.x(), size.y());
		final var mipmapEnabled = image.mipmapEnabled();
		if (mipmapEnabled)
		{
			builder.computeMipLevels();
			builder.addUsage(EImageUsage.TRANSFER_SRC.value()); // needed to generate the mipmap
			builder.addUsage(EImageUsage.TRANSFER_DST.value()); // needed to generate the mipmap
		}

		imageBackend = builder.buildNoFill(context);

		return imageBackend;
	}
}

