package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.vulkan.common.resource.image.VkImage;

public interface IImageAdapter extends IVulkanResourceAdapter, INotifierAdapter
{
	enum Features
	{
		Image,
		View
	}

	long getImagePtr();
	long getViewPtr();
	long getMemoryPtr();

	VkImage getVkImage();
}
