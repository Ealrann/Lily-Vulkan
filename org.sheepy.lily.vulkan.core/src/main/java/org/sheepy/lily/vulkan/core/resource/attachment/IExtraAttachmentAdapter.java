package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;

public interface IExtraAttachmentAdapter extends IVkImageAdapter, IAllocableAdapter<IGraphicContext>, INotifier
{
	ClearInfo getClearInfos();
	int getImageFormat();
}
