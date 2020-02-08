package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;

public interface IExtraAttachmentAdapter extends IAllocableAdapter<IGraphicContext>
{
	int getImageFormat();

	long getImageId();

	long getImageViewId();

	boolean isDepthAttachment();

	ClearInfo getClearInfos();
}
