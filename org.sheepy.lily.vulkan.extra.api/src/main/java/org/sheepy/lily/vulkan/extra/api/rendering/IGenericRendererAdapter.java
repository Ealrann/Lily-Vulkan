package org.sheepy.lily.vulkan.extra.api.rendering;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;

public interface IGenericRendererAdapter extends IAdapter
{
	PresentableEntity resolvePresentedEntity(RenderPointer renderPointer);
}
