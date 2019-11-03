package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;

public interface IGenericRendererAdapter extends IVulkanAdapter
{
	PresentableEntity resolvePresentedEntity(RenderPointer renderPointer);
}
