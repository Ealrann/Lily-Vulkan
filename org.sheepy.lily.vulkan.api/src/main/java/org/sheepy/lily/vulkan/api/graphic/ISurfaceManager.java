package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.vulkan.device.capabilities.Capabilities;
import org.sheepy.vulkan.queue.VulkanQueue;
import org.sheepy.vulkan.surface.Extent2D;
import org.sheepy.vulkan.surface.VkSurface;

public interface ISurfaceManager extends IAllocable<IGraphicContext>
{
	Extent2D getExtent();

	VkSurface getSurface();

	Capabilities getCapabilities();

	ColorDomain getColorDomain();

	int bestSupportedImageCount(int requiredImageCount);

	VulkanQueue getPresentQueue();

	boolean isPresentable();

	void setDirty(boolean dirty);
}
