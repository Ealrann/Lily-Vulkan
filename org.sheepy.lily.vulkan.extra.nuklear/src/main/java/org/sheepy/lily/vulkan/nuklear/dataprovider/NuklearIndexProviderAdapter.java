package org.sheepy.lily.vulkan.nuklear.dataprovider;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = NuklearIndexProvider.class)
@Adapter(lazy = false)
public final class NuklearIndexProviderAdapter extends Notifier<IBufferDataProviderAdapter.Features> implements
																									 IBufferDataProviderAdapter
{
	public static final long INDEX_BUFFER_SIZE = (long) Math.pow(2, 16);

	private final ByteBuffer stagingBuffer = MemoryUtil.memAlloc((int) INDEX_BUFFER_SIZE);

	private NuklearIndexProviderAdapter()
	{
		super(List.of(Features.Size, Features.Data));
	}

	@Dispose
	private void dispose()
	{
		MemoryUtil.memFree(stagingBuffer);
	}

	public ByteBuffer requestUpdate()
	{
		notify(Features.Data);
		return stagingBuffer;
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		MemoryUtil.memCopy(stagingBuffer, buffer);
	}

	@Override
	public void fetch(ByteBuffer buffer)
	{
	}

	@Override
	public long size()
	{
		return INDEX_BUFFER_SIZE;
	}
}
