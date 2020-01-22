package org.sheepy.lily.vulkan.common.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.common.graphic.ClearInfo;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;

public interface IExtraAttachmentAdapter extends IAllocableAdapter<IGraphicContext>
{
	int getImageFormat();

	long getImageId();

	long getImageViewId();

	boolean isDepthAttachment();

	ClearInfo getClearInfos();
}
