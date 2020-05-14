package org.sheepy.lily.vulkan.api.graphic;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.allocation.IAllocation;

public interface IPhysicalSurfaceAllocation extends IAllocation
{
	Vector2ic getExtent();
	VkColorDomain getColorDomain();
	int bestSupportedImageCount(int requiredImageCount);
	boolean isPresentable();
	void setDirty();

	int supportedUsageFlags();
}
