package org.sheepy.lily.vulkan.process.pipeline.task.internal;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.vulkan.api.barrier.IBufferBarrierAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;

public class BufferBarriersBackend
		extends BarriersBackend<AbstractBufferBarrier, VkBufferMemoryBarrier.Buffer>
{
	private final List<IBufferBarrierAdapter> adapters = new ArrayList<>();

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
		adapters.clear();

		for (final var bufferBarrier : barriers)
		{
			final var info = res.get();
			final var barrierAdapter = IBufferBarrierAdapter.adapt(bufferBarrier);
			adapters.add(barrierAdapter);
			barrierAdapter.fillInfo(context, bufferBarrier, info, swapIndex);
			info.srcQueueFamilyIndex(srcQueueIndex);
			info.dstQueueFamilyIndex(dstQueueIndex);
		}
		res.flip();

		return res;
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		boolean res = false;

		for (int i = 0; i < adapters.size(); i++)
		{
			final var adapter = adapters.get(i);
			if (adapter.isAllocationDirty(context))
			{
				res = true;
				break;
			}
		}

		return res;
	}
}
