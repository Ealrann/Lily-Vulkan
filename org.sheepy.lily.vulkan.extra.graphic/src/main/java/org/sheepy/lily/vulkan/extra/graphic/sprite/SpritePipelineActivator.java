package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.extra.api.sprite.ISpriteSupplier;
import org.sheepy.lily.vulkan.extra.api.sprite.ISpriteVertexSupplier;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;

import java.util.function.IntConsumer;

@ModelExtender(scope = SpriteExtension.class)
@Adapter(lazy = false)
public final class SpritePipelineActivator implements IExtender
{
	private SpritePipelineActivator(final SpriteExtension spriteExtension, final IObservatoryBuilder observatory)
	{
		final var dataSource = spriteExtension.getSpriteDataSource();
		final var spriteSupplier = dataSource.adaptNotNull(ISpriteSupplier.class);
		final var spriteVertexSupplier = dataSource.adaptNotNull(ISpriteVertexSupplier.class);
		final var spritePipeline = (GraphicsPipeline) spriteExtension.eContainer().eContainer();
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
		spritePipeline.setRecord(activation);
	}

	private static void activateAllocation(final GraphicsPipeline spritePipeline, final int spriteCount)
	{
		final var activation = spriteCount != 0;
		spritePipeline.setAllocate(activation);
	}
}
