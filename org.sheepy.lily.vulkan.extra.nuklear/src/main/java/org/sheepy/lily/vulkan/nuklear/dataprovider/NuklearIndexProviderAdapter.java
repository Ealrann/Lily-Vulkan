package org.sheepy.lily.vulkan.nuklear.dataprovider;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider;

import java.nio.ByteBuffer;
import java.util.List;

import static org.lwjgl.nuklear.Nuklear.nnk_buffer_init_fixed;

@ModelExtender(scope = NuklearIndexProvider.class)
@Adapter(lazy = false)
public final class NuklearIndexProviderAdapter extends Notifier<IBufferDataProviderAdapter.Features> implements
																									 IBufferDataProviderAdapter
{
	public static final long INDEX_BUFFER_SIZE = (long) Math.pow(2, 16);

	private long ebufPtr;
	private Runnable endTask;

	private NuklearIndexProviderAdapter()
	{
		super(List.of(Features.Size, Features.Data));
	}

	public void requestUpdate(final long ebufPtr, final Runnable endTask)
	{
		this.ebufPtr = ebufPtr;
		this.endTask = endTask;
		notify(Features.Data);
	}

	@Override
	public void fill(ByteBuffer buffer)
	{
		nnk_buffer_init_fixed(ebufPtr, MemoryUtil.memAddress(buffer), INDEX_BUFFER_SIZE);
		endTask.run();
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
