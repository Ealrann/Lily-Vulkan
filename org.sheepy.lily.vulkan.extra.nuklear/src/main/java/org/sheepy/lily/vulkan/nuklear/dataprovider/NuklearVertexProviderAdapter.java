package org.sheepy.lily.vulkan.nuklear.dataprovider;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider;

import java.nio.ByteBuffer;
import java.util.List;

import static org.lwjgl.nuklear.Nuklear.nnk_buffer_init_fixed;

@ModelExtender(scope = NuklearVertexProvider.class)
@Adapter(lazy = false)
public final class NuklearVertexProviderAdapter extends Notifier<IBufferDataProviderAdapter.Features> implements
																									  IBufferDataProviderAdapter
{
	public static final long VERTEX_BUFFER_SIZE = (long) Math.pow(2, 18);
	private long vbufPtr;

	private NuklearVertexProviderAdapter()
	{
		super(List.of(Features.Size, Features.Data));
	}

	public void requestUpdate(final long vbufPtr)
	{
		this.vbufPtr = vbufPtr;
		notify(Features.Data);
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		nnk_buffer_init_fixed(vbufPtr, MemoryUtil.memAddress(buffer), VERTEX_BUFFER_SIZE);
	}

	@Override
	public long size()
	{
		return VERTEX_BUFFER_SIZE;
	}
}
