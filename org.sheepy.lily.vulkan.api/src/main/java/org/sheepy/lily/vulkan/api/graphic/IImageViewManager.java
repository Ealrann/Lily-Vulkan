package org.sheepy.lily.vulkan.api.graphic;

import java.util.List;

import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.resource.image.VkImageView;

public interface IImageViewManager extends IAllocable
{
	List<VkImageView> getImageViews();
}
