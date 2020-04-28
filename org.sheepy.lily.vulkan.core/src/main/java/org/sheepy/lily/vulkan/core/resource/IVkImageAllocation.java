package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.game.api.resource.image.IImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;

public interface IVkImageAllocation extends IImageAllocation
{
	long getImagePtr();
	long getViewPtr();
	long getMemoryPtr();

	VkImage getVkImage();
}
