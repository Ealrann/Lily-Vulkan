package org.sheepy.lily.vulkan.nuklear.dataprovider;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataSupplier;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;

import java.nio.ByteBuffer;

import static org.lwjgl.nuklear.Nuklear.nnk_buffer_init_fixed;

@ModelExtender(scope = BufferViewer.class, name = "NkVertex")
@Adapter
@AutoLoad
public final class NuklearVertexSupplier extends Notifier<IBufferDataSupplier.Features> implements IBufferDataSupplier
{
	public static final long VERTEX_BUFFER_SIZE = (long) Math.pow(2, 18);
	private long vbufPtr;

	private NuklearVertexSupplier()
	{
		super(Features.values);
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
