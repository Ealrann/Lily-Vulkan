package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
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
		final var spriteVertexSupplier = spriteExtension.getSpriteDataSource()
														.adaptNotNull(ISpriteVertexSupplier.class);
		final var spritePipeline = (GraphicsPipeline) spriteExtension.eContainer().eContainer();
		final IntConsumer pipelineActivator = count -> activate(spritePipeline, count);

		pipelineActivator.accept(spriteVertexSupplier.entityCount());
		observatory.focus(spriteVertexSupplier).listen(pipelineActivator, ISpriteVertexSupplier.Features.EntityCount);
	}

	private static void activate(final GraphicsPipeline spritePipeline, final int count)
	{
		final var activation = count != 0;
		spritePipeline.setRecord(activation);
	}
}
