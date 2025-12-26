package org.sheepy.lily.vulkan.core.graphic;

import org.sheepy.lily.vulkan.core.resource.image.VkImageView;

import java.util.List;

public interface IImageViewManager
{
	List<? extends VkImageView> getImageViews();
}
