package org.sheepy.lily.vulkan.api.graphic;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.extender.IExtender;

public interface IPhysicalSurfaceAllocation extends IExtender
{
	Vector2ic getExtent();
	VkColorDomain getColorDomain();
	int bestSupportedImageCount(int requiredImageCount);
	boolean isPresentable();
	void setDirty();

	int supportedUsageFlags();
}
