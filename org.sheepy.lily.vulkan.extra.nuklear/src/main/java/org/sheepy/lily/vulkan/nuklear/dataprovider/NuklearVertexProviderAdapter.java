package org.sheepy.lily.vulkan.nuklear.dataprovider;

import static org.lwjgl.nuklear.Nuklear.nnk_buffer_init_fixed;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;

@Statefull
@Adapter(scope = NuklearVertexProvider.class, lazy = false)
public final class NuklearVertexProviderAdapter implements IBufferDataProviderAdapter
{
	public static final int VERTEX_SIZE = 20;
	public static final long VERTEX_BUFFER_SIZE = (long) Math.pow(2, 18);

	private final NuklearContextAdapter contextAdapter;

	private NuklearVertexProviderAdapter(NuklearVertexProvider provider)
	{
		contextAdapter = provider.getContext().adapt(NuklearContextAdapter.class);
	}

	@Load
	private static void load(NuklearVertexProvider provider)
	{
		provider.setRequestedSize(VERTEX_BUFFER_SIZE);
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		final var vbuf = contextAdapter.getVBuf();
		final long address = MemoryUtil.memAddress(buffer);
		nnk_buffer_init_fixed(vbuf.address(), address, buffer.capacity());
	}

	@Override
	public void fetch(ByteBuffer buffer)
	{}

	@Override
	public boolean hasChanged()
	{
		return contextAdapter.isDirty();
	}

}
