package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.resource.ISemaphoreAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.Semaphore;

import java.util.ArrayList;
import java.util.List;

public abstract class ExecutionRecorders<T extends ExecutionContext> implements IExecutionRecorders<T>, IAllocable<T>
{
	private List<IExecutionRecorder<? super T>> recorders;
	private IAllocationConfigurator allocationConfiguration;

	@Override
	public void configureAllocation(IAllocationConfigurator config, T context)
	{
		this.allocationConfiguration = config;
	}

	@Override
	public void allocate(T context)
	{
		recorders = List.copyOf(createRecorders(context));
		allocationConfiguration.addChildren(recorders, true);
	}

	@Override
	public void free(T context)
	{
		allocationConfiguration.removeChildren(recorders, true);
		recorders = null;
	}

	@Override
	public List<IExecutionRecorder<? super T>> getRecorders()
	{
		return recorders != null ? recorders : List.of();
	}

	protected static List<VkSemaphore> gatherSinalSemaphores(AbstractProcess process)
	{
		final var res = new ArrayList<VkSemaphore>();
		for (final var semaphore : process.getSignals())
		{
			final var allocation = semaphore.allocationHandle(ISemaphoreAllocation.class).get();
			res.add(allocation.getVkSemaphore());
		}
		return res;
	}

	protected List<WaitData> gatherWaitDatas(AbstractProcess process)
	{
		final var waitDatas = new ArrayList<WaitData>();
		for (final Semaphore waitFor : process.getWaitFor())
		{
			final var semaphoreData = convertToData(waitFor);
			waitDatas.add(semaphoreData);
		}
		return waitDatas;
	}

	protected static WaitData convertToData(Semaphore semaphore)
	{
		final var allocation = semaphore.allocationHandle(ISemaphoreAllocation.class).get();
		final var waitStage = semaphore.getWaitStage();
		return new WaitData(allocation.getVkSemaphore(), waitStage);
	}

	protected abstract List<? extends IExecutionRecorder<? super T>> createRecorders(T context);
}
