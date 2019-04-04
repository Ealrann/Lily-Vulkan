package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.nativehelper.Extent2D;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.model.ColorDomain;

public interface ISurfaceManager extends IAllocable
{
	Extent2D getExtent();

	VkSurface getSurface();

	Capabilities getCapabilities();

	ColorDomain getColorDomain();

	int bestSupportedImageCount(int requiredImageCount);

	VulkanQueue getPresentQueue();

	void setDirty(boolean dirty);
}
