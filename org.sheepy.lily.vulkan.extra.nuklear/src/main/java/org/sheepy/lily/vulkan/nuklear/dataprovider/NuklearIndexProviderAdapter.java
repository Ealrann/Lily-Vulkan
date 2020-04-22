package org.sheepy.lily.vulkan.nuklear.dataprovider;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAllocation;

import java.nio.ByteBuffer;

import static org.lwjgl.nuklear.Nuklear.nnk_buffer_init_fixed;

@ModelExtender(scope = NuklearIndexProvider.class)
@Adapter(lazy = false)
public final class NuklearIndexProviderAdapter implements IBufferDataProviderAdapter
{
	public static final long INDEX_BUFFER_SIZE = (long) Math.pow(2, 16);

	private final NuklearIndexProvider provider;

	private NuklearIndexProviderAdapter(NuklearIndexProvider provider)
	{
		this.provider = provider;
	}

	@Load
	private static void load(NuklearIndexProvider provider)
	{
		provider.setRequestedSize(INDEX_BUFFER_SIZE);
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		final var contextAdapter = provider.getContext().adapt(NuklearContextAllocation.class);
		final var ebuf = contextAdapter.getEBuf();
		final long address = MemoryUtil.memAddress(buffer);
		nnk_buffer_init_fixed(ebuf.address(), address, buffer.capacity());
	}

	@Override
	public void fetch(ByteBuffer buffer)
	{
	}

	@Override
	public boolean hasChanged()
	{
		final var contextAdapter = provider.getContext().adapt(NuklearContextAllocation.class);
		return contextAdapter.isDirty();
	}
}
