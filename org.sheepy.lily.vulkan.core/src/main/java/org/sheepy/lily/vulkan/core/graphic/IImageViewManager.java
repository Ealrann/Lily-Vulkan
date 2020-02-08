package org.sheepy.lily.vulkan.core.graphic;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.core.resource.image.VkImageView;

public interface IImageViewManager extends IAllocable<IGraphicContext>
{
	List<? extends VkImageView> getImageViews();
}
