package org.sheepy.lily.vulkan.extra.graphic.sprite;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.ISpecializationAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer;

@Adapter(scope = SpriteCountSpecialization.class)
public class SpriteCountSpecializationAdapter implements ISpecializationAdapter
{
	@Override
	public int byteCount(ISpecialization specialization)
	{
		return 4;
	}

	@Override
	public void fillBuffer(ISpecialization specialization, ByteBuffer buffer)
	{
		final var renderer = ModelUtil.findParent(specialization, SpriteRenderer.class);
		final var structures = renderer.getRenderedStructures();

		int maxSize = 0;
		for (final var structure : structures)
		{
			final int size = SpriteMonoSamplerProviderAdapter.gatherResources(structure).size();
			if (size > maxSize)
			{
				maxSize = size;
			}
		}

		buffer.putInt(maxSize);
	}
}
