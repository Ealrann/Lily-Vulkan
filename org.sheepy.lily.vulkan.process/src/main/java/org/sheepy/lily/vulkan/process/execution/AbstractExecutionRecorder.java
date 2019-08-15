package org.sheepy.lily.vulkan.process.execution;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.api.execution.ISubmission;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.execution.ICommandBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public abstract class AbstractExecutionRecorder<T extends IProcessContext>
		implements IExecutionRecorder<T>, IAllocable<T>
{
	protected final ICommandBuffer<? super T> commandBuffer;
	protected final ISubmission<? super T> submission;
	private final List<IAllocable<? super T>> allocationList;

	protected final int index;

	private boolean dirty = true;

	public AbstractExecutionRecorder(	ICommandBuffer<? super T> commandBuffer,
										ISubmission<? super T> submission,
										int index)
	{
		this.commandBuffer = commandBuffer;
		this.submission = submission;
		this.index = index;

		allocationList = List.of(commandBuffer, submission);
	}

	@Override
	public void configureAllocation(IAllocationConfiguration config, T context)
	{
		config.addChildren(allocationList);
	}

	@Override
	public void allocate(T context)
	{}

	@Override
	public void free(T context)
	{}

	@Override
	public void record(List<? extends IRecordable> recordables, List<ECommandStage> stages)
	{
		waitIdle();

		for (final ECommandStage stage : stages)
		{
			commandBuffer.start(stage);
			recordCommand(recordables, stage);
			commandBuffer.end(stage);
		}

		setDirty(false);
	}

	public boolean isBusy()
	{
		return submission.isBusy();
	}

	@Override
	public void waitIdle()
	{
		submission.waitIdle();
	}

	@Override
	public void play()
	{
		submission.submit();
	}

	@Override
	public ICommandBuffer<? super T> getCommandBuffer()
	{
		return commandBuffer;
	}

	@Override
	public ISubmission<? super T> getSubmission()
	{
		return submission;
	}

	@Override
	public boolean isDirty()
	{
		return dirty;
	}

	@Override
	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}

	protected abstract void recordCommand(	List<? extends IRecordable> adapters,
											ECommandStage stage);

}
