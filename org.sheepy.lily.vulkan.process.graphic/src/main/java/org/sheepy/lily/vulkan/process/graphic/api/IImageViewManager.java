package org.sheepy.lily.vulkan.process.graphic.api;

import java.util.List;

import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImageView;

public interface IImageViewManager extends IAllocable
{
	List<VkImageView> getImageViews();
}
