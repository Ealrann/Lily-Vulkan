package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;

public interface IExtraAttachmentAdapter extends IVkImageAdapter, IAllocableAdapter<IGraphicContext>
{
	ClearInfo getClearInfos();
	int getImageFormat();
}
