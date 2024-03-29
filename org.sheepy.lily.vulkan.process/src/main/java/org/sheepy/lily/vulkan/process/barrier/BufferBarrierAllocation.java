package org.sheepy.lily.vulkan.process.barrier;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.resource.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IBufferBarrierAllocation;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER;

@ModelExtender(scope = BufferBarrier.class)
@Allocation
@AllocationChild(allocateBeforeParent = true, features = VulkanResourcePackage.BUFFER_BARRIER__BUFFERS)
@AllocationDependency(features = VulkanResourcePackage.BUFFER_BARRIER__BUFFERS, type = IBufferReferenceAllocation.class)
public final class BufferBarrierAllocation implements IBufferBarrierAllocation
{
	private final int srcAccessMask;
	private final int dstAccessMask;
	private final IBufferReferenceAllocation bufferReferenceAllocation;

	public BufferBarrierAllocation(BufferBarrier barrier,
								   @InjectDependency(index = 0) IBufferReferenceAllocation bufferReferenceAllocation)
	{
		srcAccessMask = VulkanModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		dstAccessMask = VulkanModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());
		this.bufferReferenceAllocation = bufferReferenceAllocation;
	}

	public int barrierCount()
	{
		return bufferReferenceAllocation.getBufferCountPerInstance();
	}

	@Override
	public void fill(final VkBufferMemoryBarrier.Buffer barriers,
					 final RecordContext recordContext,
					 final int srcQueueIndex,
					 final int dstQueueIndex)
	{
		for (final var buffer : bufferReferenceAllocation.getBufferAllocations(recordContext.recordIndex))
		{
			final long ptr = buffer.getPtr();
			final long bindOffset = buffer.getBindOffset();
			final long bindSize = buffer.getBindSize();

			final var barrier = barriers.get();
			barrier.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
			barrier.buffer(ptr);
			barrier.srcAccessMask(srcAccessMask);
			barrier.dstAccessMask(dstAccessMask);
			barrier.offset(bindOffset);
			barrier.size(bindSize);
			barrier.srcQueueFamilyIndex(srcQueueIndex);
			barrier.dstQueueFamilyIndex(dstQueueIndex);
		}
	}
}
