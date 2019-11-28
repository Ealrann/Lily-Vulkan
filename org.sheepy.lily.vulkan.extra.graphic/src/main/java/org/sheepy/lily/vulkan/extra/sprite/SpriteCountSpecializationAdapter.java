package org.sheepy.lily.vulkan.extra.sprite;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.extra.api.rendering.ISpecializationAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization;

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
		final var spriteCount = (SpriteCountSpecialization) specialization;
		final var provider = spriteCount.getProvider();
		final int size = SpriteMonoSamplerProviderAdapter.gatherResources(provider).size();

		buffer.putInt(size);
	}
}
