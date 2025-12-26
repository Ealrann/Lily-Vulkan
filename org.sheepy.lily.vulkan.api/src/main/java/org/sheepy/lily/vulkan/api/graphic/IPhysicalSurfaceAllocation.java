package org.sheepy.lily.vulkan.api.graphic;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.extender.IAdapter;

public interface IPhysicalSurfaceAllocation extends IAdapter
{
	Vector2ic getExtent();
	VkColorDomain getColorDomain();
	int bestSupportedImageCount(int requiredImageCount);
	boolean isPresentable();
	void setDirty();

	int supportedUsageFlags();
}
