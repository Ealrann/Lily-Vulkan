package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryChunkPartAdapter;

@ModelExtender(scope = StaticImage.class)
@Adapter
public final class StaticImageAdapter implements IMemoryChunkPartAdapter
{
	private final StaticImage image;

	private VkImage imageBackend;

	public StaticImageAdapter(final StaticImage image)
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
		final var size = image.getSize();
		final var builder = new VkImageBuilder(image.getName(), image, size.x(), size.y());

		imageBackend = builder.buildNoFill(context);

		return imageBackend;
	}
}
