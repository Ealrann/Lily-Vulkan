package org.sheepy.lily.vulkan.process.barrier;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Observe;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IBufferBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkBufferBarrier;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@Statefull
@Adapter(scope = BufferBarrier.class)
public class BufferBarrierAdapter implements IBufferBarrierAdapter
{
	private final VkBufferBarrier vkBarrier;
	private final BufferBarrier barrier;

	private boolean loaded = false;

	public BufferBarrierAdapter(BufferBarrier barrier)
	{
		this.barrier = barrier;
		final int srcAccessMask = VulkanModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VulkanModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		vkBarrier = new VkBufferBarrier(srcAccessMask, dstAccessMask);
	}

	@Observe
	private void observe(IObservatoryBuilder observatory)
	{
		observatory.explore(VulkanResourcePackage.Literals.BUFFER_BARRIER__BUFFER)
				   .adaptNotifier(IBufferAdapter.class)
				   .listenNoParam(this::updateBarrier, IBufferAdapter.Features.Ptr);
	}

	@Override
	public void update(int index)
	{
		if (loaded == false)
		{
			updateBarrier();
			loaded = true;
		}
	}

	private void updateBarrier()
	{
		final var adapter = barrier.getBuffer().adapt(IBufferAdapter.class);

		vkBarrier.updatePtr(adapter.getPtr());
		vkBarrier.updateOffset(adapter.getBindOffset());
		vkBarrier.updateSize(adapter.getBindSize());

		// System.out.println("Update barrier: buffer="
		// + adapter.getPtr()
		// + ", offset="
		// + adapter.getBindOffset());
	}

	@Override
	public VkBufferBarrier getBackend()
	{
		return vkBarrier;
	}
}
