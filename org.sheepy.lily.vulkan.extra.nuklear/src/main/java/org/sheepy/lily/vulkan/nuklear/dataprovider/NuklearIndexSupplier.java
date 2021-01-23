package org.sheepy.lily.vulkan.nuklear.dataprovider;

import org.lwjgl.system.MemoryUtil;
import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataSupplier;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;

import java.nio.ByteBuffer;

import static org.lwjgl.nuklear.Nuklear.nnk_buffer_init_fixed;

@ModelExtender(scope = BufferViewer.class, name = "NkIndex")
@Adapter
@AutoLoad
public final class NuklearIndexSupplier extends Notifier<IBufferDataSupplier.Features> implements IBufferDataSupplier
{
	public static final long INDEX_BUFFER_SIZE = (long) Math.pow(2, 16);

	private long ebufPtr;
	private Runnable endTask;

	private NuklearIndexSupplier()
	{
		super(Features.values);
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
	public long size()
	{
		return INDEX_BUFFER_SIZE;
	}
}
