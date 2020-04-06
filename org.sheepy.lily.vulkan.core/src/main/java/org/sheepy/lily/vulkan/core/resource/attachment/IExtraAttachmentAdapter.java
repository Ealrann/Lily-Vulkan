package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;

public interface IExtraAttachmentAdapter extends IVkImageAdapter
{
	ClearInfo getClearInfos();
	int getImageFormat();
}
