package org.sheepy.vulkan.common.resource.image;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.model.resource.DepthImage;

public interface IDepthImageAdapter extends IVulkanAdapter
{
	int getDepthImageFormat();

	static IDepthImageAdapter adapt(DepthImage image)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(image, IDepthImageAdapter.class);
	}
}