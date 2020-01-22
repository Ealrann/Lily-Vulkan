package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.vulkan.resource.image.VkImage;

public interface IImageAdapter extends IVulkanResourceAdapter, INotifierAdapter
{
	enum Features
	{
		Image,
		View
	}

	VkImage getVkImage();

	long getImagePtr();
	long getViewPtr();
	long getMemoryPtr();
}
