package org.sheepy.lily.vulkan.process.barrier;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.vulkan.api.barrier.IBufferBarrierAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.vulkan.barrier.VkBufferBarrier;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = BufferBarrier.class)
public class BufferBarrierAdapter implements IBufferBarrierAdapter
{
	private final INotificationListener bufferListener = this::bufferChanged;
	private final VkBufferBarrier vkBarrier;
	private final BufferBarrier barrier;

	private boolean loaded = false;

	public BufferBarrierAdapter(BufferBarrier barrier)
	{
		this.barrier = barrier;
		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		vkBarrier = new VkBufferBarrier(srcAccessMask, dstAccessMask);
	}

	@Load
	public void load(BufferBarrier barrier)
	{
		final var bufferAdapter = barrier.getBuffer().adaptNotNull(IBufferAdapter.class);
		bufferAdapter.addListener(bufferListener, IBufferAdapter.Features.Ptr.ordinal());

		vkBarrier.updatePtr(bufferAdapter.getPtr());
	}

	@Dispose
	public void dispose(BufferBarrier barrier)
	{
		final var bufferAdapter = barrier.getBuffer().adaptNotNull(IBufferAdapter.class);
		bufferAdapter.removeListener(bufferListener, IBufferAdapter.Features.Ptr.ordinal());
	}

	@Override
	public void update(int index)
	{
		if (loaded == false)
		{
			final var adapter = barrier.getBuffer().adapt(IBufferAdapter.class);
			vkBarrier.updatePtr(adapter.getPtr());
			loaded = true;
		}
	}

	private void bufferChanged(Notification notification)
	{
		final var adapter = barrier.getBuffer().adapt(IBufferAdapter.class);
		vkBarrier.updatePtr(adapter.getPtr());
	}

	@Override
	public VkBufferBarrier getBackend()
	{
		return vkBarrier;
	}
}
