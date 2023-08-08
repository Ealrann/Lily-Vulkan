package org.sheepy.lily.vulkan.extra.api.rendering;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntitySelection;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;

public interface IEntitySelectionBuilder extends IAdapter
{
	IEntitySelection buildSelection(RenderPointer renderPointer, PresentableEntity entity);
}
