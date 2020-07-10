package org.sheepy.lily.vulkan.nuklear.dataprovider;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = NuklearVertexProvider.class)
@Adapter(lazy = false)
public final class NuklearVertexProviderAdapter extends Notifier<IBufferDataProviderAdapter.Features> implements
																									  IBufferDataProviderAdapter
{
	public static final int VERTEX_SIZE = 20;
	public static final long VERTEX_BUFFER_SIZE = (long) Math.pow(2, 18);

	private final ByteBuffer stagingBuffer = MemoryUtil.memAlloc((int) VERTEX_BUFFER_SIZE);

	private boolean needPush = false;

	private NuklearVertexProviderAdapter()
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
		needPush = true;
		notify(Features.Data);
		return stagingBuffer;
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		MemoryUtil.memCopy(stagingBuffer, buffer);
		needPush = false;
	}

	@Override
	public void fetch(ByteBuffer buffer)
	{
	}

	@Override
	public boolean needPush()
	{
		return needPush;
	}

	@Override
	public long size()
	{
		return VERTEX_BUFFER_SIZE;
	}
}
