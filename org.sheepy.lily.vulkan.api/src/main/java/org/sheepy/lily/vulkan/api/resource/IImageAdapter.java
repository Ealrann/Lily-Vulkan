package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.vulkan.resource.image.VkImage;

public interface IImageAdapter extends IDescriptedResourceAdapter
{
	VkImage getVkImage();

	long getImagePtr();
	long getViewPtr();
	long getMemoryPtr();
}
