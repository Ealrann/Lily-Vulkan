package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.game.api.resource.image.IImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;

import java.util.function.LongConsumer;

public interface IVkImageAdapter extends INotifierAdapter<IVkImageAdapter.Features>, IImageAdapter
{
	enum Features implements IFeature<LongConsumer, Features>
	{
		Image,
		View
	}

	long getImagePtr();
	long getViewPtr();
	long getMemoryPtr();

	VkImage getVkImage();
}
