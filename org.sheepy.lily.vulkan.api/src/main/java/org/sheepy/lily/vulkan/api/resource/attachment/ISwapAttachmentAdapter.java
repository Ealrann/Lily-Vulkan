package org.sheepy.lily.vulkan.api.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.graphic.ClearInfo;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;

public interface ISwapAttachmentAdapter extends IAdapter, IAllocable<IGraphicContext>
{
	int getImageFormat();

	long getImageId();

	long getImageViewId();

	boolean isDepthAttachment();

	ClearInfo getClearInfos();
}
