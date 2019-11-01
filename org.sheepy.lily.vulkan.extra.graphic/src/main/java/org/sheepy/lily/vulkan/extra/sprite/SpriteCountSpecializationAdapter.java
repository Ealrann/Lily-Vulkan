package org.sheepy.lily.vulkan.extra.sprite;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.extra.api.rendering.ISpecializationAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization;

@Statefull
@Adapter(scope = SpriteCountSpecialization.class, lazy = false)
public class SpriteCountSpecializationAdapter implements ISpecializationAdapter
{
	private int size;

	@Load
	public void load(SpriteCountSpecialization specialization)
	{
		final var spriteCount = specialization;
		final var provider = spriteCount.getProvider();
		final var adapter = provider.adapt(SpriteMonoSamplerProviderAdapter.class);
		size = adapter.gatherResources(provider).size();
	}

	@Override
	public int byteCount(ISpecialization specialization)
	{
		return 4;
	}

	@Override
	public void fillBuffer(ISpecialization specialization, ByteBuffer buffer)
	{
		buffer.putInt(size);
	}
}
