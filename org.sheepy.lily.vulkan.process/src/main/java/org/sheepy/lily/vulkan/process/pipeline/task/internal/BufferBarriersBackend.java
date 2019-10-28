package org.sheepy.lily.vulkan.process.pipeline.task.internal;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.barrier.IBufferBarrierAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;

public class BufferBarriersBackend
		extends BarriersBackend<AbstractBufferBarrier, VkBufferMemoryBarrier.Buffer>
{
	public BufferBarriersBackend(	int swapCount,
									int srcQueueIndex,
									int dstQueueIndex,
									List<? extends AbstractBufferBarrier> barriers)
	{
		super(swapCount, srcQueueIndex, dstQueueIndex, barriers);
	}

	@Override
	protected VkBufferMemoryBarrier.Buffer[] createBufferArray(int count)
	{
		return new VkBufferMemoryBarrier.Buffer[count];
	}

	@Override
	protected VkBufferMemoryBarrier.Buffer allocateAndFillBuffer(	IExecutionContext context,
																	final List<? extends AbstractBufferBarrier> barriers,
																	int swapIndex,
																	final int srcQueueIndex,
																	final int dstQueueIndex)
	{
		final var res = VkBufferMemoryBarrier.calloc(barriers.size());

		final List<IAllocable<?>> newDependencies = new ArrayList<>();

		allocationConfiguration.clearDependencies();
		allocationConfiguration.clearChildren();

		for (final var bufferBarrier : barriers)
		{
			final var info = res.get();
			final var barrierAdapter = bufferBarrier.adaptNotNull(IBufferBarrierAdapter.class);

			if (barrierAdapter instanceof IAllocable)
			{
				newDependencies.add((IAllocable<?>) barrierAdapter);
			}

			barrierAdapter.fillInfo(context, bufferBarrier, info, swapIndex);
			info.srcQueueFamilyIndex(srcQueueIndex);
			info.dstQueueFamilyIndex(dstQueueIndex);
		}
		res.flip();

		allocationConfiguration.addChildren(newDependencies);
		allocationConfiguration.addDependencies(newDependencies);

		return res;
	}
}
