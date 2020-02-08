package org.sheepy.lily.vulkan.core.graphic;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.core.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.core.execution.queue.VulkanQueue;
import org.sheepy.lily.vulkan.core.window.Extent2D;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;

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
