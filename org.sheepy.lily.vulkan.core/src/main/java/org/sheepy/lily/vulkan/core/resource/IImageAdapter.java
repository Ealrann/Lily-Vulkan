package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;

public interface IImageAdapter extends INotifierAdapter
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
