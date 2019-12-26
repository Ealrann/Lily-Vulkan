package org.sheepy.lily.vulkan.process.pipeline.task.internal;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.barrier.IImageBarrierAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;

public class ImageBarriersBackend
		extends BarriersBackend<AbstractImageBarrier, VkImageMemoryBarrier.Buffer>
{
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

		allocationConfiguration.clearDependencies();
		allocationConfiguration.clearChildren();

		final List<IAllocable<?>> newDependencies = new ArrayList<>();
		for (final var imageBarrier : barriers)
		{
			final var info = res.get();
			final IImageBarrierAdapter<IExecutionContext> barrierAdapter = imageBarrier.adaptNotNullGeneric(IImageBarrierAdapter.class);

			if (barrierAdapter instanceof IAllocable)
			{
				newDependencies.add((IAllocable<?>) barrierAdapter);
			}

			barrierAdapter.fillInfo(context, imageBarrier, info, swapIndex);
			info.srcQueueFamilyIndex(srcQueueIndex);
			info.dstQueueFamilyIndex(dstQueueIndex);
		}
		res.flip();

		allocationConfiguration.addChildren(newDependencies);
		allocationConfiguration.addDependencies(newDependencies);

		return res;
	}
}
