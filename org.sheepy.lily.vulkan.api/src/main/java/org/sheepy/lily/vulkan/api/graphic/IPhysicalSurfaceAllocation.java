package org.sheepy.lily.vulkan.api.graphic;

import org.joml.Vector2ic;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;

public interface IPhysicalSurfaceAllocation
{
	Vector2ic getExtent();
	VkColorDomain getColorDomain();
	int bestSupportedImageCount(int requiredImageCount);
	boolean isPresentable();
	void setDirty(boolean dirty);

	int supportedUsageFlags();
}
