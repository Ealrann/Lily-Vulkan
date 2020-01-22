package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.common.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.common.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.common.process.IProcessContext;
import org.sheepy.lily.vulkan.common.resource.ISemaphoreAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public abstract class ExecutionRecorders<T extends IProcessContext>
		implements IExecutionRecorders<T>, IAllocable<T>
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

	protected List<VkSemaphore> gatherSinalSemaphores(AbstractProcess process)
	{
		final var res = new ArrayList<VkSemaphore>();
		for (final var semaphore : process.getSignals())
		{
			res.add(semaphore.adaptNotNull(ISemaphoreAdapter.class).getVkSemaphore());
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
		final var adapter = semaphore.adaptNotNull(ISemaphoreAdapter.class);
		final var waitStage = semaphore.getWaitStage();
		return new WaitData(adapter.getVkSemaphore(), waitStage);
	}

	protected abstract List<? extends IExecutionRecorder<? super T>> createRecorders(T context);
}
