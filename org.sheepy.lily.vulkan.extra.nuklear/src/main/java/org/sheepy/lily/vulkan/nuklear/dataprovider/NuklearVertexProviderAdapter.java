package org.sheepy.lily.vulkan.nuklear.dataprovider;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAllocation;

import java.nio.ByteBuffer;

import static org.lwjgl.nuklear.Nuklear.nnk_buffer_init_fixed;

@ModelExtender(scope = NuklearVertexProvider.class)
@Adapter(lazy = false)
public final class NuklearVertexProviderAdapter implements IBufferDataProviderAdapter
{
	public static final int VERTEX_SIZE = 20;
	public static final long VERTEX_BUFFER_SIZE = (long) Math.pow(2, 18);

	private final NuklearVertexProvider provider;

	private NuklearVertexProviderAdapter(NuklearVertexProvider provider)
	{
		this.provider = provider;
	}

	@Load
	private static void load(NuklearVertexProvider provider)
	{
		provider.setRequestedSize(VERTEX_BUFFER_SIZE);
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		final var contextAdapter = provider.getContext().allocationHandle(NuklearContextAllocation.class).get();
		final var vbuf = contextAdapter.getVBuf();
		final long address = MemoryUtil.memAddress(buffer);
		nnk_buffer_init_fixed(vbuf.address(), address, buffer.capacity());
	}

	@Override
	public void fetch(ByteBuffer buffer)
	{
	}

	@Override
	public boolean hasChanged()
	{
		final var contextAdapter = provider.getContext().allocationHandle(NuklearContextAllocation.class).get();
		return contextAdapter.isDirty();
	}

}
