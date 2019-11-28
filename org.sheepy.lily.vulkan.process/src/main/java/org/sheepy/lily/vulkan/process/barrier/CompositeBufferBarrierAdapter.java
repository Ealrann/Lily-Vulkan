package org.sheepy.lily.vulkan.process.barrier;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.barrier.IBufferBarrierAdapter;
import org.sheepy.lily.vulkan.common.resource.IDataProviderAlignmentAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.util.VkModelUtil;

@Adapter(scope = CompositeBufferBarrier.class)
public class CompositeBufferBarrierAdapter implements IBufferBarrierAdapter
{
	@Override
	public void fillInfo(	IAllocationContext context,
							AbstractBufferBarrier barrier,
							VkBufferMemoryBarrier info,
							int swapIndex)
	{
		final var bufferBarrier = (CompositeBufferBarrier) barrier;
		final var dataProvider = bufferBarrier.getDataProvider();
		final int instance = bufferBarrier.getInstance();
		final var adapter = dataProvider.adapt(IDataProviderAlignmentAdapter.class);
		final long ptr = adapter.getBufferPtr();
		final long size = adapter.getInstanceSize();
		final long offset = adapter.getInstanceOffset(instance);

		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		info.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		info.buffer(ptr);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
		info.offset(offset);
		info.size(size);
	}
	
	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return IBufferBarrierAdapter.super.isAllocationDirty(context);
	}
}
