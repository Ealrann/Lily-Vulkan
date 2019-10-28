package org.sheepy.lily.vulkan.api.resource.attachment;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.graphic.ClearInfo;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;

public interface ISwapAttachmentAdapter extends IVulkanAdapter, IAllocable<IGraphicContext>
{
	int getImageFormat();

	long getImageId();

	long getImageViewId();

	boolean isDepthAttachment();

	ClearInfo getClearInfos();
}
