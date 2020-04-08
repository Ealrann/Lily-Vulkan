package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.game.api.resource.image.IImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;

import java.util.function.LongConsumer;

public interface IVkImageAdapter extends INotifierAdapter<IVkImageAdapter.Features>, IImageAdapter
{
	interface Features extends IFeatures<Features>
	{
		Feature<LongConsumer, Features> Image = Feature.newFeature();
		Feature<LongConsumer, Features> View = Feature.newFeature();
	}

	long getImagePtr();
	long getViewPtr();
	long getMemoryPtr();

	VkImage getVkImage();
}
