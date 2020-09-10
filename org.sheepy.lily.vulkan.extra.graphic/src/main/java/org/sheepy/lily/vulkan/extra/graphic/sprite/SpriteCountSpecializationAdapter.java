package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.ISpecializationAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureResourceAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure;

import java.nio.ByteBuffer;

@ModelExtender(scope = SpriteCountSpecialization.class)
@Adapter(singleton = true)
public final class SpriteCountSpecializationAdapter implements ISpecializationAdapter
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
		final int maxSize = structures.stream().mapToInt(SpriteCountSpecializationAdapter::structureResourceSize).sum();
		buffer.putInt(maxSize);
	}

	private static int structureResourceSize(final SpriteStructure s)
	{
		return s.adapt(IStructureResourceAdapter.class).getImages().size();
	}
}
