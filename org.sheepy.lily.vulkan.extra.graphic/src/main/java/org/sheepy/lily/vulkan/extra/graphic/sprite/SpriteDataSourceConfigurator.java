package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;

@ModelExtender(scope = SpriteExtension.class)
@Adapter
@AutoLoad
public final class SpriteDataSourceConfigurator implements IAdapter
{
	private SpriteDataSourceConfigurator(final SpriteExtension spriteExtension)
	{
		final var dataSource = spriteExtension.spriteDataSource();

		spriteExtension.vertexBufferViewer().dataSource(dataSource);
		spriteExtension.indexBufferViewer().dataSource(spriteExtension);
	}
}
