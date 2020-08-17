package org.sheepy.lily.vulkan.core.resource.attachment;

import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageAllocation;

public interface IExtraAttachmentAllocation extends IVkImageAllocation
{
	ClearInfo getClearInfos();
	int getImageFormat();
}
