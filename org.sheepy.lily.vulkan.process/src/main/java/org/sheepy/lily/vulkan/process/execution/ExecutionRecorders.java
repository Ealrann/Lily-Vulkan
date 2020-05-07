package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.resource.ISemaphoreAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.Semaphore;

import java.util.ArrayList;
import java.util.List;

public abstract class ExecutionRecorders implements IExecutionRecorders
{
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
}
