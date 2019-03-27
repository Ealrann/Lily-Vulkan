package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.vulkan.api.allocation.IAllocationNode;
import org.sheepy.lily.vulkan.api.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.api.execution.ISubmission;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;

public abstract class AbstractExecutionRecorder implements IExecutionRecorder, IAllocationNode
{
	protected final ICommandBuffer commandBuffer;
	protected final ISubmission submission;
	protected final List<Object> allocationList = new ArrayList<>();

	protected final int index;

	private boolean dirty = true;

	public AbstractExecutionRecorder(	ICommandBuffer commandBuffer,
										ISubmission submission,
										int index)
	{
		this.commandBuffer = commandBuffer;
		this.submission = submission;
		this.index = index;

		allocationList.add(commandBuffer);
		allocationList.add(submission);
	}

	@Override
	public void record(List<? extends IRecordable> recordables, List<ECommandStage> stages)
	{
		submission.waitIdle();

		for (final ECommandStage stage : stages)
		{
			commandBuffer.start(stage);
			recordCommand(recordables, stage);
			commandBuffer.end(stage);
		}

		setDirty(false);
	}

	@Override
	public void play()
	{
		submission.submit();
	}

	@Override
	public ICommandBuffer getCommandBuffer()
	{
		return commandBuffer;
	}

	@Override
	public ISubmission getSubmission()
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

	@Override
	public List<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}

	protected abstract void recordCommand(	List<? extends IRecordable> adapters,
											ECommandStage stage);

}
