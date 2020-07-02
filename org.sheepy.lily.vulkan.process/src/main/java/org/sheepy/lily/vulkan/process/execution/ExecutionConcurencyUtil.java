package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.resource.ISemaphoreAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.Semaphore;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExecutionConcurencyUtil
{
	private ExecutionConcurencyUtil()
	{
	}

	public static List<VkSemaphore> gatherSinalSemaphores(AbstractProcess process)
	{
		return process.getSignals()
					  .stream()
					  .map(semaphore -> semaphore.adapt(ISemaphoreAllocation.class))
					  .map(ISemaphoreAllocation::getVkSemaphore)
					  .collect(Collectors.toUnmodifiableList());
	}

	public static List<WaitData> gatherWaitDatas(AbstractProcess process)
	{
		return streamWaitDatas(process).collect(Collectors.toUnmodifiableList());
	}

	public static Stream<WaitData> streamWaitDatas(AbstractProcess process)
	{
		return process.getWaitFor().stream().map(ExecutionConcurencyUtil::convertToData);
	}

	public static WaitData convertToData(Semaphore semaphore)
	{
		final var allocation = semaphore.adapt(ISemaphoreAllocation.class);
		final var waitStage = semaphore.getWaitStage();
		return new WaitData(allocation.getVkSemaphore(), waitStage);
	}
}
