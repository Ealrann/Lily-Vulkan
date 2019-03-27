package org.sheepy.lily.vulkan.api.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.nativehelper.ClearInfo;
import org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment;

public interface ISwapAttachmentAdapter extends IVulkanAdapter, IAllocable
{
	int getImageFormat();

	long getImageId();

	long getImageViewId();
	
	boolean isDepthAttachment();
	
	ClearInfo getClearInfos();

	static ISwapAttachmentAdapter adapt(ISwapAttachment image)
	{
		return IAdapterFactoryService.INSTANCE.adapt(image, ISwapAttachmentAdapter.class);
	}
}
