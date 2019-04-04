package org.sheepy.lily.vulkan.api.graphic;

import java.util.List;

import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.nativehelper.resource.VkImageView;

public interface IImageViewManager extends IAllocable
{
	List<VkImageView> getImageViews();
}
