package org.sheepy.lily.vulkan.common.resource.image;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.DepthImage;

public interface IDepthImageAdapter extends IVulkanAdapter
{
	int getDepthImageFormat();

	static IDepthImageAdapter adapt(DepthImage image)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(image, IDepthImageAdapter.class);
	}
}