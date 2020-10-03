package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;

@ModelExtender(scope = SpriteExtension.class)
@Adapter(lazy = false)
public final class SpriteDataSourceConfigurator implements IExtender
{
	private SpriteDataSourceConfigurator(final SpriteExtension spriteExtension)
	{
		final var dataSource = spriteExtension.getSpriteDataSource();

		spriteExtension.getVertexBufferViewer().setDataSource(dataSource);
		spriteExtension.getIndexBufferViewer().setDataSource(spriteExtension);
	}
}
