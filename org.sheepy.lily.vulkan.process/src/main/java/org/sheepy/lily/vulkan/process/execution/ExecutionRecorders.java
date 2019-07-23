package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.resource.ISemaphoreAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationNode;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public abstract class ExecutionRecorders<T extends IProcessContext>
		implements IExecutionRecorders<T>, IAllocationNode<T>, IAllocable<T>
{
	private List<IExecutionRecorder<? super T>> recorders;

	@Override
	public void allocate(MemoryStack stack, T context)
	{
		recorders = List.copyOf(createRecorders(stack, context));
	}

	@Override
	public void free(T context)
	{
		recorders = null;
	}

	@Override
	public boolean isAllocationDirty(T context)
	{
		return false;
	}

	@Override
	public List<IExecutionRecorder<? super T>> getAllocationChildren()
	{
		return recorders;
	}

	@Override
	public List<IExecutionRecorder<? super T>> getRecorders()
	{
		return recorders;
	}

	protected List<VkSemaphore> gatherSinalSemaphores(AbstractProcess process)
	{
		final var res = new ArrayList<VkSemaphore>();
		for (final Semaphore semaphore : process.getSignals())
		{
			res.add(ISemaphoreAdapter.adapt(semaphore).getVkSemaphore());
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
		final var adapter = ISemaphoreAdapter.adapt(semaphore);
		final var waitStage = semaphore.getWaitStage();
		return new WaitData(adapter.getVkSemaphore(), waitStage);
	}

	protected abstract List<? extends IExecutionRecorder<? super T>> createRecorders(	MemoryStack stack,
																						T context);
}
