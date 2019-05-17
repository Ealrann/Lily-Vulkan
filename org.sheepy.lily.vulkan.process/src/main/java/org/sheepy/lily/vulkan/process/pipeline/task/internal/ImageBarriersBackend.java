package org.sheepy.lily.vulkan.process.pipeline.task.internal;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.vulkan.api.barrier.IImageBarrierAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;

public class ImageBarriersBackend
		extends BarriersBackend<AbstractImageBarrier, VkImageMemoryBarrier.Buffer>
{
	private final List<IImageBarrierAdapter<IExecutionContext>> adapters = new ArrayList<>();

	public ImageBarriersBackend(int swapCount,
								int srcQueueIndex,
								int dstQueueIndex,
								List<? extends AbstractImageBarrier> barriers)
	{
		super(swapCount, srcQueueIndex, dstQueueIndex, barriers);
	}

	@Override
	protected VkImageMemoryBarrier.Buffer[] createBufferArray(int count)
	{
		return new VkImageMemoryBarrier.Buffer[count];
	}

	@Override
	protected VkImageMemoryBarrier.Buffer allocateAndFillBuffer(IExecutionContext context,
																final List<? extends AbstractImageBarrier> barriers,
																int swapIndex,
																final int srcQueueIndex,
																final int dstQueueIndex)
	{
		final var res = VkImageMemoryBarrier.calloc(barriers.size());
		adapters.clear();

		for (final var imageBarrier : barriers)
		{
			final var info = res.get();
			@SuppressWarnings("unchecked")
			final var barrierAdapter = (IImageBarrierAdapter<IExecutionContext>) IImageBarrierAdapter
					.adapt(imageBarrier);
			adapters.add(barrierAdapter);
			barrierAdapter.fillInfo(context, imageBarrier, info, swapIndex);
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
