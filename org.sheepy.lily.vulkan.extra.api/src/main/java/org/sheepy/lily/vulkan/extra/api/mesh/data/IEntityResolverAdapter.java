package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.RenderPointer;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;

public interface IEntityResolverAdapter extends IAdapter
{
	PresentableEntity resolveEntity(RenderPointer pointer);
}
