package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.vulkan.resource.image.VkImage;

public interface IImageAdapter extends IDescriptedResourceAdapter
{
	VkImage getVkImage();

	long getImagePtr();
	long getViewPtr();
	long getMemoryPtr();

	public static IImageAdapter adapt(Image image)
	{
		return IAdapterFactoryService.INSTANCE.adapt(image, IImageAdapter.class);
	}
}
