package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
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
		final IntConsumer indexCountConfigurator = count -> spriteExtension.drawTask().indexCount(count);
		final var indexSupplier = spriteExtension.adaptNotNull(IIndexSupplier.class);
		final int currentIndexCount = indexSupplier.getIndexCount();

		observatory.focus(indexSupplier).listen(indexCountConfigurator, IIndexSupplier.Features.IndexCount);
		indexCountConfigurator.accept(currentIndexCount);
	}
}
