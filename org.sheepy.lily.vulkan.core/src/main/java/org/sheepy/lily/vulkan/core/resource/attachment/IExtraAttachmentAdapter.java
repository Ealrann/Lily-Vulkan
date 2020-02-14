package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.resource.IImageAdapter;

public interface IExtraAttachmentAdapter extends IImageAdapter, IAllocableAdapter<IGraphicContext>, INotifier
{
	ClearInfo getClearInfos();
	int getImageFormat();
}
