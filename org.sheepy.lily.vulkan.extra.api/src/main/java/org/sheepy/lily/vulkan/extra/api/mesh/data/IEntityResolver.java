package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.extra.api.rendering.RenderPointer;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;

public interface IEntityResolver extends IExtender
{
	PresentableEntity resolveEntity(RenderPointer pointer);
}
