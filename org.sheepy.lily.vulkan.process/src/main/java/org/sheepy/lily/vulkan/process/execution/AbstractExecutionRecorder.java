package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.api.execution.ISubmission;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.execution.ICommandBuffer;
import org.sheepy.vulkan.execution.IRecordable;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.execution.IRecordable.RecordContext.IExecutionIdleListener;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public abstract class AbstractExecutionRecorder<T extends IProcessContext>
		implements IExecutionRecorder<T>, IAllocable<T>
{
	protected final ICommandBuffer<? super T> commandBuffer;
	protected final ISubmission<? super T> submission;
	private final List<IAllocable<? super T>> allocationList;
	private final RecordContext[] contexts = new RecordContext[ECommandStage.VALUES.size()];

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
	public final void configureAllocation(IAllocationConfigurator config, T context)
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
	public final void record(List<? extends IRecordable> recordables, List<ECommandStage> stages)
	{
		waitIdle();

		final List<IExecutionIdleListener> listeners = new ArrayList<>();
		for (int i = 0; i < stages.size(); i++)
		{
			final ECommandStage stage = stages.get(i);
			commandBuffer.start(stage);
			final var context = getOrCreateContext(stage);
			context.clearListeners();
			recordCommand(recordables, context, stage);
			commandBuffer.end(stage);
			listeners.addAll(context.getExecutionIdleListeners());
		}

		submission.setExecutionIdleListeners(listeners);

		setDirty(false);
	}

	private final RecordContext getOrCreateContext(ECommandStage stage)
	{
		final int stageIndex = stage.ordinal();
		var context = contexts[stageIndex];
		if (context == null)
		{
			final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
			context = new RecordContext(vkCommandBuffer, stage, index);
			contexts[stageIndex] = context;
		}
		return context;
	}

	public boolean isBusy()
	{
		return submission.isBusy();
	}

	@Override
	public void checkFence()
	{
		submission.checkFence();
	}

	@Override
	public void waitIdle()
	{
		submission.waitIdle();
	}

	@Override
	public IFenceView play()
	{
		return submission.submit();
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
											RecordContext context,
											ECommandStage stage);

}
