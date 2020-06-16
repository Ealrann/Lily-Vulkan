package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.resource.ISemaphoreAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

public abstract class ExecutionRecordersAllocation implements IExecutionRecorders
{
	private final List<ECommandStage> stages;

	private List<IRecordable> recordables;

	protected ExecutionRecordersAllocation(List<? extends IRecordable> recordables, List<ECommandStage> stages)
	{
		this.recordables = List.copyOf(recordables);
		this.stages = List.copyOf(stages);
	}

	protected void updateRecordables(List<? extends IRecordable> recordables)
	{
		this.recordables = List.copyOf(recordables);
	}

	protected static List<VkSemaphore> gatherSinalSemaphores(AbstractProcess process)
	{
		final var res = new ArrayList<VkSemaphore>();
		for (final var semaphore : process.getSignals())
		{
			final var allocation = semaphore.adapt(ISemaphoreAllocation.class);
			res.add(allocation.getVkSemaphore());
		}
		return res;
	}

	@Override
	public void checkFence()
	{
		final var recorders = getRecorders();
		for (int i = 0; i < recorders.size(); i++)
		{
			final var recorder = recorders.get(i);
			recorder.checkFence();
		}
	}

	@Override
	public void waitIdle()
	{
		for (final var recorder : getRecorders())
		{
			recorder.waitIdle();
		}
	}

	@Override
	public IExecutionRecorder prepare(final int index)
	{
		updatePipelines(index);
		if (isRecordNeeded(index))
		{
			invalidate();
		}
		final var recorder = getRecorders().get(index);
		if (isRecordNeeded(index) || recorder.isDirty())
		{
			recorder.record(recordables, stages);
		}

		return recorder;
	}

	@Override
	public void invalidate()
	{
		for (final var recorder : getRecorders())
		{
			recorder.setDirty(true);
		}
	}

	private void updatePipelines(int index)
	{
		for (int i = 0; i < recordables.size(); i++)
		{
			final var recordable = recordables.get(i);
			if (recordable.isActive())
			{
				recordable.update(index);
			}
		}
	}

	private boolean isRecordNeeded(int index)
	{
		boolean res = false;
		for (int i = 0; i < recordables.size(); i++)
		{
			final var pipelineAdapter = recordables.get(i);
			if (pipelineAdapter.isActive())
			{
				res |= pipelineAdapter.isRecordDirty(index);
			}
		}
		return res;
	}

	protected abstract List<? extends IExecutionRecorder> getRecorders();

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
		final var allocation = semaphore.adapt(ISemaphoreAllocation.class);
		final var waitStage = semaphore.getWaitStage();
		return new WaitData(allocation.getVkSemaphore(), waitStage);
	}
}
