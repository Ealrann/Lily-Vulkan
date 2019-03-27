package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.allocation.IAllocationNode;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.lily.vulkan.resource.semaphore.SemaphoreAdapter;

public abstract class ExecutionRecorders implements IAllocationNode, IAllocable
{
	private List<IExecutionRecorder> recorders;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		recorders = List.copyOf(createRecorders(stack, context));
	}

	@Override
	public void free(IAllocationContext context)
	{
		recorders = null;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	@Override
	public List<? extends Object> getAllocationChildren()
	{
		return recorders;
	}

	public List<IExecutionRecorder> getRecorders()
	{
		return recorders;
	}

	protected List<VkSemaphore> gatherSinalSemaphores(AbstractProcess process)
	{
		final var res = new ArrayList<VkSemaphore>();
		for (final Semaphore semaphore : process.getSignals())
		{
			res.add(SemaphoreAdapter.adapt(semaphore).getVkSemaphore());
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
		final var adapter = SemaphoreAdapter.adapt(semaphore);
		final var waitStage = semaphore.getWaitStage();
		return new WaitData(adapter.getVkSemaphore(), waitStage);
	}

	protected abstract List<IExecutionRecorder> createRecorders(	MemoryStack stack,
																IAllocationContext context);
}
