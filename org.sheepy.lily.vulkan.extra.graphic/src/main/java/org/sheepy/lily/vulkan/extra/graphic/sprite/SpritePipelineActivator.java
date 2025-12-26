package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.sprite.ISpriteSupplier;
import org.sheepy.lily.vulkan.extra.api.sprite.ISpriteVertexSupplier;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;

import java.util.function.IntConsumer;

@ModelExtender(scope = SpriteExtension.class)
@Adapter
@AutoLoad
public final class SpritePipelineActivator implements IAdapter
{
	private SpritePipelineActivator(final SpriteExtension spriteExtension, final IObservatoryBuilder observatory)
	{
		final var dataSource = spriteExtension.spriteDataSource();
		final var spriteSupplier = dataSource.adaptNotNull(ISpriteSupplier.class);
		final var spriteVertexSupplier = dataSource.adaptNotNull(ISpriteVertexSupplier.class);
		final var spritePipeline = ModelUtil.findParent(spriteExtension, GraphicsPipeline.class);
		final IntConsumer recordActivator = entityCount -> activateRecord(spritePipeline, entityCount);
		final Runnable allocationActivator = () -> activateAllocation(spritePipeline, spriteSupplier.imageCount());

		recordActivator.accept(spriteVertexSupplier.entityCount());
		observatory.focus(spriteVertexSupplier).listen(recordActivator, ISpriteVertexSupplier.Features.EntityCount);

		allocationActivator.run();
		observatory.focus(spriteSupplier).listenNoParam(allocationActivator, ISpriteSupplier.Features.Sprites);
	}

	private static void activateRecord(final GraphicsPipeline spritePipeline, final int entityCount)
	{
		final var activation = entityCount != 0;
		spritePipeline.record(activation);
	}

	private static void activateAllocation(final GraphicsPipeline spritePipeline, final int spriteCount)
	{
		final var activation = spriteCount != 0;
		spritePipeline.allocate(activation);
	}
}
