package org.sheepy.lily.vulkan.api.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.graphic.ClearInfo;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment;
import org.sheepy.vulkan.allocation.IAllocable;

public interface ISwapAttachmentAdapter extends IVulkanAdapter, IAllocable<IGraphicContext>
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
