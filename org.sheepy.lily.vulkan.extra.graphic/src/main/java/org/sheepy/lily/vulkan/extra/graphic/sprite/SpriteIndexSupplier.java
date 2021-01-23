package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexSupplier;
import org.sheepy.lily.vulkan.extra.api.sprite.ISpriteVertexSupplier;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;

import java.nio.ByteBuffer;

@ModelExtender(scope = SpriteExtension.class, identifier = "SpriteIndex")
@Adapter
public final class SpriteIndexSupplier extends Notifier<IIndexSupplier.Features> implements IIndexSupplier
{
	private int indexCount;
	private long size = 0;
	private int entityCount;

	private SpriteIndexSupplier(final SpriteExtension spriteExtension, final IObservatoryBuilder observatory)
	{
		super(Features.values);
		final var spriteSupplier = spriteExtension.getSpriteDataSource().adaptNotNull(ISpriteVertexSupplier.class);

		reload(spriteSupplier.entityCount());
		observatory.focus(spriteSupplier).listen(this::reload, ISpriteVertexSupplier.Features.EntityCount);
	}

	private void reload(final int entityCount)
	{
		this.entityCount = entityCount;
		indexCount = 6 * entityCount;
		notify(Features.Data);

		final var newSize = indexCount * Integer.BYTES;
		if (newSize != size)
		{
			size = newSize;
			notify(Features.IndexCount, getIndexCount());
			notify(Features.Size, size);
		}
	}

	@Override
	public long size()
	{
		return size;
	}

	@Override
	public int getIndexCount()
	{
		return indexCount;
	}

	@Override
	public void fill(final ByteBuffer buffer)
	{
		for (int i = 0; i < entityCount; i++)
		{
			final int offset = i * 4;
			buffer.putInt(offset);
			buffer.putInt(offset + 3);
			buffer.putInt(offset + 1);
			buffer.putInt(offset);
			buffer.putInt(offset + 2);
			buffer.putInt(offset + 3);
		}
		buffer.flip();
	}
}
