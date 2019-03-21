package org.sheepy.lily.vulkan.common.resource.image;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.common.execution.IResourceAllocable;
import org.sheepy.lily.vulkan.model.resource.DepthImage;

public interface IDepthImageAdapter extends IResourceAllocable, IVulkanAdapter
{
	int getDepthImageFormat();

	static IDepthImageAdapter adapt(DepthImage image)
	{
		return IAdapterFactoryService.INSTANCE.adapt(image, IDepthImageAdapter.class);
	}
}