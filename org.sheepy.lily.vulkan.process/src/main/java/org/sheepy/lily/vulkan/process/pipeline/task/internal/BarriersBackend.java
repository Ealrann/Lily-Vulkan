package org.sheepy.lily.vulkan.process.pipeline.task.internal;

import java.util.List;

import org.lwjgl.system.NativeResource;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.Barrier;

public abstract class BarriersBackend<T extends Barrier, Y extends NativeResource>
		implements IAllocable<IExecutionContext>
{
	private final int swapCount;
	private final int srcQueueIndex;
	private final int dstQueueIndex;
	private final List<? extends T> barriers;

	protected IAllocationConfigurator allocationConfiguration;
	private Y[] barrierInfos = null;

	public BarriersBackend(	final int swapCount,
							final int srcQueueIndex,
							final int dstQueueIndex,
							final List<? extends T> barriers)
	{
		this.swapCount = swapCount;
		this.srcQueueIndex = srcQueueIndex;
		this.dstQueueIndex = dstQueueIndex;
		this.barriers = barriers;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IExecutionContext context)
	{
		this.allocationConfiguration = config;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		barrierInfos = createBufferArray(swapCount);
		if (barriers.isEmpty() == false)
		{
			for (int swapIndex = 0; swapIndex < swapCount; swapIndex++)
			{
				barrierInfos[swapIndex] = allocateAndFillBuffer(context,
																barriers,
																swapIndex,
																srcQueueIndex,
																dstQueueIndex);
			}
		}
	}

	public Y get(int swapIndex)
	{
		return barrierInfos[swapIndex];
	}

	@Override
	public void free(IExecutionContext context)
	{
		if (barrierInfos != null)
		{
			for (int i = 0; i < barrierInfos.length; i++)
			{
				final var barrier = barrierInfos[i];
				if (barrier != null)
				{
					barrier.free();
				}
			}
			barrierInfos = null;
		}
	}

	protected abstract Y[] createBufferArray(int count);
	protected abstract Y allocateAndFillBuffer(	IExecutionContext context,
												List<? extends T> barriers,
												int swapIndex,
												final int srcQueueIndex,
												final int dstQueueIndex);
}