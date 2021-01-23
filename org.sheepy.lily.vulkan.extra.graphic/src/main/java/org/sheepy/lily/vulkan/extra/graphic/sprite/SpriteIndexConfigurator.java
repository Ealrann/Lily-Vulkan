package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexSupplier;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;

import java.util.function.IntConsumer;

@ModelExtender(scope = SpriteExtension.class)
@Adapter
@AutoLoad
public final class SpriteIndexConfigurator implements IAdapter
{
	private SpriteIndexConfigurator(final SpriteExtension spriteExtension, final IObservatoryBuilder observatory)
	{
		final IntConsumer indexCountConfigurator = count -> spriteExtension.getDrawTask().setIndexCount(count);
		final var indexSupplier = spriteExtension.adaptNotNull(IIndexSupplier.class);
		final int currentIndexCount = indexSupplier.getIndexCount();

		observatory.focus(indexSupplier).listen(indexCountConfigurator, IIndexSupplier.Features.IndexCount);
		indexCountConfigurator.accept(currentIndexCount);
	}
}
