package org.sheepy.lily.vulkan.process.barrier;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IBufferBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkBufferBarrier;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@ModelExtender(scope = BufferBarrier.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.BUFFER_BARRIER__BUFFER, type = IBufferAllocation.class)
public final class BufferBarrierAllocation implements IBufferBarrierAdapter
{
	private final VkBufferBarrier vkBarrier;

	public BufferBarrierAllocation(BufferBarrier barrier, @InjectDependency(index = 0) IBufferAllocation buffer)
	{
		final int srcAccessMask = VulkanModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VulkanModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		vkBarrier = new VkBufferBarrier(srcAccessMask, dstAccessMask);
		updateBarrier(buffer);
	}

	@Override
	public void update(int index)
	{
	}

	@UpdateDependency(index = 0)
	private void updateBarrier(IBufferAllocation buffer)
	{
		vkBarrier.updatePtr(buffer.getPtr());
		vkBarrier.updateOffset(buffer.getBindOffset());
		vkBarrier.updateSize(buffer.getBindSize());

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
