package org.sheepy.lily.vulkan.process.barrier;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IBufferBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkBufferBarrier;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@ModelExtender(scope = BufferBarrier.class)
@Adapter
public class BufferBarrierAdapter implements IBufferBarrierAdapter
{
	private final VkBufferBarrier vkBarrier;
	private final BufferBarrier barrier;

	private boolean loaded = false;

	public BufferBarrierAdapter(BufferBarrier barrier, IObservatoryBuilder observatory)
	{
		this.barrier = barrier;
		final int srcAccessMask = VulkanModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VulkanModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		vkBarrier = new VkBufferBarrier(srcAccessMask, dstAccessMask);

		observatory.explore(VulkanResourcePackage.Literals.BUFFER_BARRIER__BUFFER)
				   .allocation(IBufferAllocation.class)
				   .listen(this::updateBarrier);

	}

	@Override
	public void update(int index)
	{
		if (loaded == false)
		{
			final var allocation = barrier.getBuffer()
										  .allocationHandle(IBufferAllocation.class)
										  .get();
			updateBarrier(allocation);
			loaded = true;
		}
	}

	private void updateBarrier(IBufferAllocation newAllocation)
	{
		vkBarrier.updatePtr(newAllocation.getPtr());
		vkBarrier.updateOffset(newAllocation.getBindOffset());
		vkBarrier.updateSize(newAllocation.getBindSize());

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
