package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure;

import java.util.List;

@ModelExtender(scope = SpriteRenderer.class)
@Adapter(lazy = false)
public class SpriteRendererDeactivator implements IExtender
{
	@Load
	private static void load(SpriteRenderer renderer)
	{
		final long spriteCount = renderer.getRenderedStructures()
										 .stream()
										 .map(SpriteStructure::getSprites)
										 .mapToLong(List::size)
										 .sum();

		renderer.setMaintaining(spriteCount != 0);
	}
}
