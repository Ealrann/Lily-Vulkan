package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;

@ModelExtender(scope = SpriteExtension.class)
@Adapter
@AutoLoad
public final class SpriteDataSourceConfigurator implements IAdapter
{
	private SpriteDataSourceConfigurator(final SpriteExtension spriteExtension)
	{
		final var dataSource = spriteExtension.getSpriteDataSource();

		spriteExtension.getVertexBufferViewer().setDataSource(dataSource);
		spriteExtension.getIndexBufferViewer().setDataSource(spriteExtension);
	}
}
