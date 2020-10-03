package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexSupplier;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;

import java.util.function.IntConsumer;

@ModelExtender(scope = SpriteExtension.class)
@Adapter(lazy = false)
public final class SpriteIndexConfigurator implements IExtender
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
