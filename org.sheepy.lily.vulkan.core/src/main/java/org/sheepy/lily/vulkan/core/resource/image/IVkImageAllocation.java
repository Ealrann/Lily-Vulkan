package org.sheepy.lily.vulkan.core.resource.image;

import org.sheepy.lily.game.api.resource.image.IImageAllocation;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;

public interface IVkImageAllocation extends IImageAllocation
{
	long getImagePtr();
	long getViewPtr();

	ImageBackend getImageBackend();
	VkImage getVkImage();

	void attach(final IRecordContext recordContext);
}
