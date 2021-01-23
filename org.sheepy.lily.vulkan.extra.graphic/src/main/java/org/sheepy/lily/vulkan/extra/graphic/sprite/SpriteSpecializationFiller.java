package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.lwjgl.system.MemoryUtil;
import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.extra.api.sprite.ISpriteSupplier;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;

import java.nio.ByteBuffer;

@ModelExtender(scope = SpriteExtension.class)
@Adapter
@AutoLoad
public final class SpriteSpecializationFiller implements IAdapter
{
	private static final int BYTES = 2 * Integer.BYTES;

	private final ByteBuffer data = MemoryUtil.memAlloc(BYTES);
	private final int pipelineIndex;

	private SpriteSpecializationFiller(final SpriteExtension spriteExtension, final IObservatoryBuilder observatory)
	{
		final var pipeline = (GraphicsPipeline) spriteExtension.eContainer().eContainer();
		final var pipelinePkg = (PipelinePkg) pipeline.eContainer();
		final var spriteSupplier = spriteExtension.getSpriteDataSource().adaptNotNull(ISpriteSupplier.class);
		final Runnable spriteCountUpdater = () -> fillSpecializationBuffer(spriteSupplier.imageCount());

		spriteExtension.getSpritePipelineSpecialization().setData(data);
		pipelineIndex = pipelinePkg.getPipelines().indexOf(pipeline);
		spriteCountUpdater.run();
		observatory.focus(spriteSupplier).listenNoParam(spriteCountUpdater, ISpriteSupplier.Features.Sprites);
	}

	private void fillSpecializationBuffer(int spriteCount)
	{
		data.putInt(pipelineIndex);
		data.putInt(spriteCount);
		data.flip();
	}
}
