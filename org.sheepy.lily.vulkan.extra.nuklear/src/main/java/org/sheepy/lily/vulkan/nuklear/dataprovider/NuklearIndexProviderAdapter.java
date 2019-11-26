package org.sheepy.lily.vulkan.nuklear.dataprovider;

import static org.lwjgl.nuklear.Nuklear.nnk_buffer_init_fixed;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;

@Statefull
@Adapter(scope = NuklearIndexProvider.class)
public class NuklearIndexProviderAdapter implements IBufferDataProviderAdapter
{
	public static final long INDEX_BUFFER_SIZE = (long) Math.pow(2, 16);

	private final NuklearContextAdapter contextAdapter;

	private NuklearIndexProviderAdapter(NuklearIndexProvider provider)
	{
		contextAdapter = provider.getContext().adapt(NuklearContextAdapter.class);
	}

	@Override
	public long getSize()
	{
		return INDEX_BUFFER_SIZE;
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		final var ebuf = contextAdapter.getEBuf();
		final long address = MemoryUtil.memAddress(buffer);
		nnk_buffer_init_fixed(ebuf.address(), address, buffer.capacity());
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
