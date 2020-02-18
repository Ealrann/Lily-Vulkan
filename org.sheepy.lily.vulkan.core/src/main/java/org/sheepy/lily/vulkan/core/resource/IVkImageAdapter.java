package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.game.api.resource.image.IImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;

public interface IVkImageAdapter extends INotifierAdapter, IImageAdapter
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
