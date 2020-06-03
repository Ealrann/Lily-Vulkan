package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;

public interface IGenericRendererAdapter extends IExtender
{
	PresentableEntity resolvePresentedEntity(RenderPointer renderPointer);
}
